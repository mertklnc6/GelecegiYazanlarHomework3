package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.BodyTypeService;
import com.turkcell.rentacar.business.dtos.requests.bodyTypes.CreateBodyTypeRequest;
import com.turkcell.rentacar.business.dtos.requests.bodyTypes.UpdateBodyTypeRequest;
import com.turkcell.rentacar.business.dtos.responses.bodyTypes.CreatedBodyTypeResponse;
import com.turkcell.rentacar.business.dtos.responses.bodyTypes.DeletedBodyTypeResponse;
import com.turkcell.rentacar.business.dtos.responses.bodyTypes.GotBodyTypeResponse;
import com.turkcell.rentacar.business.dtos.responses.bodyTypes.UpdatedBodyTypeResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/bodyTypes")
public class BodyTypeController {

    private BodyTypeService bodyTypeService; //IoC inversion of control


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedBodyTypeResponse add(@RequestBody CreateBodyTypeRequest createBodyTypeRequest){
        return bodyTypeService.add(createBodyTypeRequest);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<GotBodyTypeResponse> getAll(){
        return bodyTypeService.getAll();
    }
//
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GotBodyTypeResponse getById(int id){

        return bodyTypeService.getById(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedBodyTypeResponse update(@RequestBody UpdateBodyTypeRequest updateBodyTypeRequest){
        return bodyTypeService.update(updateBodyTypeRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeletedBodyTypeResponse delete(@RequestBody int id){
        return bodyTypeService.delete(id);
    }
}
