package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.business.dtos.requests.fuels.CreateFuelRequest;
import com.turkcell.rentacar.business.dtos.requests.fuels.UpdateFuelRequest;
import com.turkcell.rentacar.business.dtos.responses.brands.GetAllBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.fuels.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fuels")
public class FuelController {

    private FuelService fuelService; //IoC inversion of control


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedFuelResponse add(@RequestBody CreateFuelRequest createFuelRequest){
        return fuelService.add(createFuelRequest);
    }
    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllFuelResponse> getAll(){
        return this.fuelService.getAll();
    }
//
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdFuelResponse getById(int id){

        return fuelService.getById(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedFuelResponse update(@RequestBody UpdateFuelRequest updateFuelRequest){
        return fuelService.update(updateFuelRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeletedFuelResponse delete(@RequestBody int id){
        return fuelService.delete(id);
    }
}
