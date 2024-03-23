package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.business.dtos.requests.fuels.CreateFuelRequest;
import com.turkcell.rentacar.business.dtos.requests.fuels.UpdateFuelRequest;
import com.turkcell.rentacar.business.dtos.responses.fuels.CreatedFuelResponse;
import com.turkcell.rentacar.business.dtos.responses.fuels.DeletedFuelResponse;
import com.turkcell.rentacar.business.dtos.responses.fuels.GotFuelResponse;
import com.turkcell.rentacar.business.dtos.responses.fuels.UpdatedFuelResponse;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.FuelRepository;
import com.turkcell.rentacar.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FuelManager implements FuelService {

    private FuelRepository fuelRepository;
    private ModelMapperService modelMapperService;
    @Override
    public CreatedFuelResponse add(CreateFuelRequest createFuelRequest) {
        Fuel fuel = this.modelMapperService.forRequest().map(createFuelRequest,Fuel.class);
        fuel.setCreatedDate(LocalDateTime.now());
        Fuel createdFuel =  fuelRepository.save(fuel);
        CreatedFuelResponse createdFuelResponse = this.modelMapperService.forResponse().map(createdFuel,CreatedFuelResponse.class);
        return createdFuelResponse;
    }

    @Override
    public GotFuelResponse getById(int id) {
        Fuel fuel = this.fuelRepository.findById(id).orElse(null);
        if(fuel != null){
            GotFuelResponse gotFuelResponse = this.modelMapperService.forResponse().map(fuel, GotFuelResponse.class);
            return gotFuelResponse;
        } else {
            return null;
        }
    }

    @Override
    public List<GotFuelResponse> getAll() {
        List<Fuel> fuels = this.fuelRepository.findAll();
        return fuels.stream().map(fuel -> this.modelMapperService.forResponse().map(fuel,GotFuelResponse.class)).collect(Collectors.toList());
    }

    @Override
    public UpdatedFuelResponse update(UpdateFuelRequest updateFuelRequest) {
        Fuel fuel = fuelRepository.findById(updateFuelRequest.getId()).orElse(null);
        if(fuel != null){
            fuel.setName(updateFuelRequest.getName());
            fuel.setUpdatedDate(LocalDateTime.now());
            fuelRepository.save(fuel);
            return this.modelMapperService.forResponse().map(fuel,UpdatedFuelResponse.class);
        }
        return null;
    }

    @Override
    public DeletedFuelResponse delete(int id) {
        Fuel fuel = this.fuelRepository.findById(id).orElse(null);
        if(fuel != null){
            fuel.setDeletedDate(LocalDateTime.now());
            return this.modelMapperService.forResponse().map(fuel,DeletedFuelResponse.class);
        }
        return null;
    }


}
