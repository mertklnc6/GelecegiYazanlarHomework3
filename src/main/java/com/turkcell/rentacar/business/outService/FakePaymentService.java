package com.turkcell.rentacar.business.outService;

import com.turkcell.rentacar.business.dtos.requests.payment.CreatePaymentRequest;
import com.turkcell.rentacar.business.dtos.responses.payment.CreatedPaymentResponse;


public interface FakePaymentService {
    CreatedPaymentResponse makePayment(CreatePaymentRequest createPaymentRequest);

}
