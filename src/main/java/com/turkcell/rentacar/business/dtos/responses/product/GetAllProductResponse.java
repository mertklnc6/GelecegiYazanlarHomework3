package com.turkcell.rentacar.business.dtos.responses.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllProductResponse {
    private int id;

    private String name;

    private double price;

    private int quantity;

    private String description;
}
