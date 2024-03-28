package com.turkcell.rentacar.business.dtos.requests.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatePaymentRequest {

    private double balance;
    private int customerId;
    private int rentalId;
}
