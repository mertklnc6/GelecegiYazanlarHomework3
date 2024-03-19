package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BodyTypeService;
import com.turkcell.rentacar.business.dtos.requests.bodyTypes.CreateBodyTypeRequest;
import com.turkcell.rentacar.business.dtos.requests.bodyTypes.UpdateBodyTypeRequest;
import com.turkcell.rentacar.business.dtos.responses.bodyTypes.CreatedBodyTypeResponse;
import com.turkcell.rentacar.business.dtos.responses.bodyTypes.DeletedBodyTypeResponse;
import com.turkcell.rentacar.business.dtos.responses.bodyTypes.GotBodyTypeResponse;
import com.turkcell.rentacar.business.dtos.responses.bodyTypes.UpdatedBodyTypeResponse;

import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.BodyTypeRepository;
import com.turkcell.rentacar.entities.concretes.BodyType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BodyTypeManager implements BodyTypeService {

    private BodyTypeRepository bodyTypeRepository;
    private ModelMapperService modelMapperService;



    @Override
    public CreatedBodyTypeResponse add(CreateBodyTypeRequest createBodyTypeRequest) {
        BodyType bodyType = this.modelMapperService.forRequest().map(createBodyTypeRequest,BodyType.class);
        bodyType.setCreatedDate(LocalDateTime.now());
        BodyType createdBodyType =  bodyTypeRepository.save(bodyType);
        CreatedBodyTypeResponse createdBodyTypeResponse = this.modelMapperService.forResponse().map(createdBodyType,CreatedBodyTypeResponse.class);
        return createdBodyTypeResponse;
    }

    @Override
    public GotBodyTypeResponse getById(int id) {
        BodyType bodyType = this.bodyTypeRepository.findById(id).orElse(null);
        if(bodyType != null){
            GotBodyTypeResponse gotBodyTypeResponse = this.modelMapperService.forResponse().map(bodyType, GotBodyTypeResponse.class);
            return gotBodyTypeResponse;
        } else {
            return null;
        }
    }

    @Override
    public List<GotBodyTypeResponse> getAll() {
        List<BodyType> bodyTypes = this.bodyTypeRepository.findAll();
        return bodyTypes.stream().map(bodyType -> this.modelMapperService.forResponse().map(bodyType,GotBodyTypeResponse.class)).collect(Collectors.toList());
    }

    @Override
    public UpdatedBodyTypeResponse update(UpdateBodyTypeRequest updateBodyTypeRequest) {
        BodyType bodyType = bodyTypeRepository.findById(updateBodyTypeRequest.getId()).orElse(null);
        if(bodyType != null){
            bodyType.setName(updateBodyTypeRequest.getName());
            bodyType.setUpdatedDate(LocalDateTime.now());
            bodyTypeRepository.save(bodyType);
            return this.modelMapperService.forResponse().map(bodyType,UpdatedBodyTypeResponse.class);
        }
        return null;
    }

    @Override
    public DeletedBodyTypeResponse delete(int id) {
        BodyType bodyType = this.bodyTypeRepository.findById(id).orElse(null);
        if(bodyType != null){
            bodyType.setDeleted(true);
            return this.modelMapperService.forResponse().map(bodyType,DeletedBodyTypeResponse.class);
        }
        return null;
    }


}
