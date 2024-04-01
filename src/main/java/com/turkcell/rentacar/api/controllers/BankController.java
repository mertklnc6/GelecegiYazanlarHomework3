package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.outService.CreateBankInformationRequest;
import com.turkcell.rentacar.business.outService.CreatedBankInformationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/bank")
public class BankController {

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedBankInformationResponse check(@RequestBody CreateBankInformationRequest createBankInformationRequest){
        CreatedBankInformationResponse createdBankInformationResponse = new CreatedBankInformationResponse();
        createdBankInformationResponse
                .setMakePayment(Math.random() % 2000 > createBankInformationRequest.getTotalPrice());
        return createdBankInformationResponse;
    }
}
