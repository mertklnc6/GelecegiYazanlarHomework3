package com.turkcell.rentacar.business.outService;

import com.turkcell.rentacar.business.dtos.requests.payment.CreatePaymentRequest;
import org.springframework.web.client.RestTemplate;

public class PaymentManager implements PaymentService {
    private RestTemplate restTemplate;

    @Override
    public CreatedPaymentResponse makePayment(CreatePaymentRequest createPaymentRequest) {
        String url = "http://localhost:8081/payment/"; //Burayı düzeltmeyi unutmayın


        return this.restTemplate.getForObject(url, CreatedPaymentResponse.class);
    }
}
