package com.turkcell.rentacar.business.dtos.responses.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedPaymentResponse {
    private boolean makePayment;
}
