package com.turkcell.rentacar.business.dtos.responses.rental_product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllRentalProductsResponse {
    private int rentalId;
    private int productId;
}
