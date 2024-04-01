package com.turkcell.rentacar.business.outService;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBankInformationRequest {
    private int totalPrice;
    private String accountNumber;
    private String expirationMonth;
    private String expirationYear;
    private String cvv;
}
