package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.CorporateCustomerService;
import com.turkcell.rentacar.business.dtos.requests.customer.CreateCorporateCustomerRequest;
import com.turkcell.rentacar.business.dtos.requests.customer.CreateIndividualCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.customer.CreatedCorporateCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.CreatedIndividualCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.GotCorporateCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.GotIndividualCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/corporates")
public class CorporateCustomerController {
    private CorporateCustomerService corporateCustomerService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCorporateCustomerResponse add(@RequestBody CreateCorporateCustomerRequest createCorporateCustomerRequest) {
        return this.corporateCustomerService.add(createCorporateCustomerRequest);

    }
    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GotCorporateCustomerResponse> getAll(){
        return this.corporateCustomerService.getAll();
    }

}
