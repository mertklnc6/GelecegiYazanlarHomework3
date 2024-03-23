package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.business.dtos.requests.transmissions.CreateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.requests.transmissions.UpdateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.responses.transmissions.CreatedTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.transmissions.DeletedTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.transmissions.GotTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.transmissions.UpdatedTransmissionResponse;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TransmissionManager implements TransmissionService {

    private TransmissionRepository transmissionRepository;
    private ModelMapperService modelMapperService;



    @Override
    public CreatedTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest) {
        Transmission transmission = this.modelMapperService.forRequest().map(createTransmissionRequest,Transmission.class);
        transmission.setCreatedDate(LocalDateTime.now());
        Transmission createdTransmission =  transmissionRepository.save(transmission);
        CreatedTransmissionResponse createdTransmissionResponse = this.modelMapperService.forResponse().map(createdTransmission,CreatedTransmissionResponse.class);
        return createdTransmissionResponse;
    }

    @Override
    public GotTransmissionResponse getById(int id) {
        Transmission transmission = this.transmissionRepository.findById(id).orElse(null);
        if(transmission != null){
            GotTransmissionResponse gotTransmissionResponse = this.modelMapperService.forResponse().map(transmission, GotTransmissionResponse.class);
            return gotTransmissionResponse;
        } else {
            return null;
        }
    }

    @Override
    public List<GotTransmissionResponse> getAll() {
        List<Transmission> transmissions = this.transmissionRepository.findAll();
        return transmissions.stream().map(transmission -> this.modelMapperService.forResponse().map(transmission,GotTransmissionResponse.class)).collect(Collectors.toList());
    }

    @Override
    public UpdatedTransmissionResponse update(UpdateTransmissionRequest updateTransmissionRequest) {
        Transmission transmission = transmissionRepository.findById(updateTransmissionRequest.getId()).orElse(null);
        if(transmission != null){
            transmission.setName(updateTransmissionRequest.getName());
            transmission.setUpdatedDate(LocalDateTime.now());
            transmissionRepository.save(transmission);
            return this.modelMapperService.forResponse().map(transmission,UpdatedTransmissionResponse.class);
        }
        return null;
    }

    @Override
    public DeletedTransmissionResponse delete(int id) {
        Transmission transmission = this.transmissionRepository.findById(id).orElse(null);
        if(transmission != null){
            transmission.setDeletedDate(LocalDateTime.now());
            return this.modelMapperService.forResponse().map(transmission,DeletedTransmissionResponse.class);
        }
        return null;
    }


}
