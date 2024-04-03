package com.turkcell.rentacar.business.dtos.requests.rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRentalProductRequest {
    private int productId;
    private int quantity;
}
