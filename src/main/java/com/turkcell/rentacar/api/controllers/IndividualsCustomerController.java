package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.IndividualCustomerService;
import com.turkcell.rentacar.business.dtos.requests.customer.CreateIndividualCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.customer.CreatedIndividualCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.GotIndividualCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/individuals")
public class IndividualsCustomerController {
    private IndividualCustomerService individualCustomerService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedIndividualCustomerResponse add(@RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        return this.individualCustomerService.add(createIndividualCustomerRequest);

    }
    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GotIndividualCustomerResponse> getAll(){
        return this.individualCustomerService.getAll();
    }
}
