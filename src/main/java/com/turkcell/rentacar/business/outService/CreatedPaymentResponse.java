package com.turkcell.rentacar.business.outService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedPaymentResponse {
    private boolean makePayment;
}
