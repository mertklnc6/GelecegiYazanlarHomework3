package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.business.dtos.requests.models.CreateModelRequest;
import com.turkcell.rentacar.business.dtos.requests.models.UpdateModelRequest;
import com.turkcell.rentacar.business.dtos.responses.models.CreatedModelResponse;
import com.turkcell.rentacar.business.dtos.responses.models.DeletedModelResponse;
import com.turkcell.rentacar.business.dtos.responses.models.GotModelResponse;
import com.turkcell.rentacar.business.dtos.responses.models.UpdatedModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/models")
public class ModelController {

    private ModelService modelService; //IoC inversion of control


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedModelResponse add(@RequestBody CreateModelRequest createModelRequest){
        return modelService.add(createModelRequest);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<GotModelResponse> getAll(){
        return modelService.getAll();
    }
//
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GotModelResponse getById(int id){

        return modelService.getById(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedModelResponse update(@RequestBody UpdateModelRequest updateModelRequest){
        return modelService.update(updateModelRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeletedModelResponse delete(@RequestBody int id){
        return modelService.delete(id);
    }
}
