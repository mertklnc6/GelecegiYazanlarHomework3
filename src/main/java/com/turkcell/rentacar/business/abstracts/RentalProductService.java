package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.responses.rental_product.GetAllRentalProductsResponse;
import com.turkcell.rentacar.entities.concretes.Product;
import com.turkcell.rentacar.entities.concretes.Rental;
import com.turkcell.rentacar.entities.concretes.RentalProduct;

import java.util.List;
import java.util.Set;

public interface RentalProductService {
    void add(Rental rental, List<RentalProduct> products);
    List<GetAllRentalProductsResponse> getAll();
}
