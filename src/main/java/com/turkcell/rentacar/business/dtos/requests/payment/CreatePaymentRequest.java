package com.turkcell.rentacar.business.dtos.requests.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatePaymentRequest {

    private String cardNumber;

    private String cardholder;

    private int cardExpirationYear;

    private int cardExpirationMonth;

    private String cardCvv;

    private double balance;


}
