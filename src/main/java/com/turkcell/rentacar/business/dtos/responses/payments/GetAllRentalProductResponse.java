package com.turkcell.rentacar.business.dtos.responses.payments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class GetAllRentalProductResponse {
    private int productId;
    private int quantity;
}
