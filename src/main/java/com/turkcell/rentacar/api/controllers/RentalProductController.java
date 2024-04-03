package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.RentalProductService;
import com.turkcell.rentacar.business.dtos.responses.rental_product.GetAllRentalProductsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/rentalProduct")
public class RentalProductController {
    private RentalProductService rentalProductService;

    @GetMapping
    public List<GetAllRentalProductsResponse> getAll(){
        return this.rentalProductService.getAll();
    }
}
