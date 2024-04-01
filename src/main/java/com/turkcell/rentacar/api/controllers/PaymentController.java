package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.PaymentService;
import com.turkcell.rentacar.business.dtos.responses.payments.GetAllPaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/payments")
public class PaymentController {
    private PaymentService paymentService;
    @GetMapping("/getAll")
    public List<GetAllPaymentResponse> getAll(){
        return this.paymentService.getAll();
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable int id){
        this.paymentService.delete(id);
    }
}
