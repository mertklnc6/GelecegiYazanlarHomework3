package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.dtos.requests.payment.CreatePaymentRequest;
import com.turkcell.rentacar.business.dtos.responses.payment.CreatedPaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fakepayments")
public class FakePaymentController {

    @PostMapping("/payment")
    public CreatedPaymentResponse makePayment(@RequestBody CreatePaymentRequest createPaymentRequest) {
        CreatedPaymentResponse createdPaymentResponse = new CreatedPaymentResponse();
        createdPaymentResponse.setMakePayment(true);
        return createdPaymentResponse;
    }
}
