package com.turkcell.rentacar.business.outService;

import com.turkcell.rentacar.business.dtos.requests.payment.CreatePaymentRequest;

public class PaymentManager implements PaymentService{
    @Override
    public boolean makePayment(CreatePaymentRequest createPaymentRequest) {
        return true;
    }
}
