package com.turkcell.rentacar.business.dtos.responses.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedPaymentResponse {
    private boolean isPaymentSuccess;

    private int customerId;

    private int paymentId;

    private LocalDateTime paymentDate;

}
