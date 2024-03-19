package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.business.dtos.requests.transmissions.CreateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.requests.transmissions.UpdateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.responses.transmissions.CreatedTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.transmissions.DeletedTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.transmissions.GotTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.transmissions.UpdatedTransmissionResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/transmissions")
public class TransmissionController {

    private TransmissionService transmissionService; //IoC inversion of control


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedTransmissionResponse add(@RequestBody CreateTransmissionRequest createTransmissionRequest){
        return transmissionService.add(createTransmissionRequest);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<GotTransmissionResponse> getAll(){
        return transmissionService.getAll();
    }
//
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GotTransmissionResponse getById(int id){

        return transmissionService.getById(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedTransmissionResponse update(@RequestBody UpdateTransmissionRequest updateTransmissionRequest){
        return transmissionService.update(updateTransmissionRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeletedTransmissionResponse delete(@RequestBody int id){
        return transmissionService.delete(id);
    }
}
