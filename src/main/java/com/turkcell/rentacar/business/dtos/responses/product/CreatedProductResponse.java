package com.turkcell.rentacar.business.dtos.responses.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatedProductResponse {
    private int id;

    private String name;

    private double price;

    private int quantity;

    private String description;
}
