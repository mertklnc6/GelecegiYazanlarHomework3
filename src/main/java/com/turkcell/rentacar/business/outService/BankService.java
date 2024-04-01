package com.turkcell.rentacar.business.outService;


public interface BankService {
    CreatedBankInformationResponse makePayment(CreateBankInformationRequest createBankInformationRequest);

}
