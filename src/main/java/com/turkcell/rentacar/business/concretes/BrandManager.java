package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.dtos.requests.brands.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.brands.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.brands.CreatedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brands.DeletedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brands.GotBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brands.UpdatedBrandResponse;
import com.turkcell.rentacar.business.rules.BrandBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;


    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        brand.setCreatedDate(LocalDateTime.now());
        Brand createdBrand =  brandRepository.save(brand);
        CreatedBrandResponse createdBrandResponse = this.modelMapperService.forResponse().map(createdBrand,CreatedBrandResponse.class);
        return createdBrandResponse;
    }

    @Override
    public GotBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElse(null);
        if(brand != null){
            GotBrandResponse gotBrandResponse = this.modelMapperService.forResponse().map(brand, GotBrandResponse.class);
            return gotBrandResponse;
        } else {
            return null;
        }
    }

    @Override
    public List<GotBrandResponse> getAll() {
        List<Brand> brands = this.brandRepository.findAll();
        return brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand,GotBrandResponse.class)).collect(Collectors.toList());
    }

    @Override
    public UpdatedBrandResponse update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = brandRepository.findById(updateBrandRequest.getId()).orElse(null);
        if(brand != null){
            brand.setName(updateBrandRequest.getName());
            brand.setUpdatedDate(LocalDateTime.now());
            brandRepository.save(brand);
            return this.modelMapperService.forResponse().map(brand,UpdatedBrandResponse.class);
        }
        return null;
    }

    @Override
    public DeletedBrandResponse delete(int id) {
        Brand brand = this.brandRepository.findById(id).orElse(null);
        if(brand != null){
            brand.setDeleted(true);
            return this.modelMapperService.forResponse().map(brand,DeletedBrandResponse.class);
        }
        return null;
    }


}
