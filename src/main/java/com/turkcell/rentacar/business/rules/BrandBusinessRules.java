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
    public void isBrandExistById(int id){
        Optional<Brand> brand = brandRepository.findById(id);
        if(brand.isEmpty()){
            throw new BusinessException("Brand Does not Exist");
        }
    }
    public void processActiveBrandsOnly() {
        List<Brand> brands = brandRepository.findByDeletedDateIsNull();
        if (brands.isEmpty()) {
            throw new BusinessException("AllBrandsAreDeletedOrThereAreNoBrands");
        }
    }

}
