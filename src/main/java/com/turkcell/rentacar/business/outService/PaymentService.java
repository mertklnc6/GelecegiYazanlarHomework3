package com.turkcell.rentacar.business.outService;

import com.turkcell.rentacar.business.dtos.requests.payment.CreatePaymentRequest;
import org.springframework.stereotype.Service;


public interface PaymentService {
    boolean makePayment(CreatePaymentRequest createPaymentRequest);

}
