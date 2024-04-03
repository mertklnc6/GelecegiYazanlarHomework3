package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.RentalProductService;
import com.turkcell.rentacar.business.dtos.responses.rental_product.GetAllRentalProductsResponse;
import com.turkcell.rentacar.business.rules.RentalProductBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.RentalProductRepository;
import com.turkcell.rentacar.entities.concretes.Product;
import com.turkcell.rentacar.entities.concretes.Rental;
import com.turkcell.rentacar.entities.concretes.RentalProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentalProductManager implements RentalProductService {
    private RentalProductRepository rentalProductRepository;
    private ModelMapperService modelMapperService;
    private RentalProductBusinessRules rentalProductBusinessRules;

    @Override
    public void add(Rental rental, List<RentalProduct> products){
        this.rentalProductBusinessRules.setRentalProductEntities(rental,products);
    }

    public List<GetAllRentalProductsResponse> getAll(){
        return this.rentalProductRepository.findAll().stream().map(rentalProduct -> this.modelMapperService.forResponse().
                map(rentalProduct, GetAllRentalProductsResponse.class)).collect(Collectors.toList());
    }
}
