package com.turkcell.rentacar.business.outService;

import com.turkcell.rentacar.business.dtos.requests.payment.CreatePaymentRequest;
import com.turkcell.rentacar.business.dtos.responses.payment.CreatedPaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Service
public class FakePaymentManager implements FakePaymentService {
    private RestTemplate restTemplate;

    @Override
    public CreatedPaymentResponse makePayment(CreatePaymentRequest createPaymentRequest) {
        String url = "http://localhost:8081/payment/"; //Portu düzeltmeyi unutmayın :)))))))

        return this.restTemplate.getForObject(url, CreatedPaymentResponse.class);
    }
}
