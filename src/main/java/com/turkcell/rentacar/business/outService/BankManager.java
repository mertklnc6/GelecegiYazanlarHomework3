package com.turkcell.rentacar.business.outService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BankManager implements BankService {
    private RestTemplate restTemplate;

    @Override
    public CreatedBankInformationResponse makePayment(CreateBankInformationRequest createBankInformationRequest) {
        String url = "http://localhost:8080/api/v1/bank/add";
        ResponseEntity<CreatedBankInformationResponse> createdCustomerPaymentInformationResponse =
                this.restTemplate.postForEntity(url,createBankInformationRequest, CreatedBankInformationResponse.class);
        return createdCustomerPaymentInformationResponse.getBody();
    }

}
