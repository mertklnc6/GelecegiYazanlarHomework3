package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    BrandRepository brandRepository;

    public void brandNameCanNotBeDuplicated(String brandName){
        Optional<Brand> brand = brandRepository.findByNameIgnoreCase(brandName);
        if(brand.isPresent()){
            throw new BusinessException("BrandExists");
        }
    }
    public void brandIdCanNotFound(int id){
        Optional<Brand> brand = brandRepository.findById(id);
        if(!brand.isPresent()){
            throw new BusinessException("BrandNotExists");
        }
    }
    public void processActiveBrandsOnly() {
        Optional<List<Brand>> optionalBrands = brandRepository.findByIsDeletedFalse();
        if (!optionalBrands.isPresent()) {
            throw new BusinessException("AllBrandsAreDeletedOrThereAreNoBrands");
        }
    }

}
