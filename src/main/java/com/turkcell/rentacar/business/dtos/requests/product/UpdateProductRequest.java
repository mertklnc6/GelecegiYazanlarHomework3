package com.turkcell.rentacar.business.dtos.requests.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateProductRequest {
    private int id;

    private String name;

    private double price;

    private int quantity;

    private String description;
}
