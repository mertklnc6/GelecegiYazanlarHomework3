package com.turkcell.rentacar.business.outService;

import com.turkcell.rentacar.business.dtos.requests.payment.CreatePaymentRequest;


public interface PaymentService {
    CreatedPaymentResponse makePayment(CreatePaymentRequest createPaymentRequest);

}
