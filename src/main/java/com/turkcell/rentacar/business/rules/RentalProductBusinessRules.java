package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.dataAccess.abstracts.RentalProductRepository;
import com.turkcell.rentacar.entities.concretes.Product;
import com.turkcell.rentacar.entities.concretes.Rental;
import com.turkcell.rentacar.entities.concretes.RentalProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class RentalProductBusinessRules {
    private RentalProductRepository rentalProductRepository;

    public void setRentalProductEntities(Rental rental, List<RentalProduct> products){
        for (RentalProduct product:products){
            RentalProduct rentalProduct = new RentalProduct();
            rentalProduct.setProduct(product.getProduct());
            rentalProduct.setRental(rental);
            this.rentalProductRepository.save(rentalProduct);
        }
    }
}
