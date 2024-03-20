package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.dtos.requests.brands.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.brands.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.brands.CreatedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brands.DeletedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brands.GotBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brands.UpdatedBrandResponse;
import com.turkcell.rentacar.business.rules.BrandBusinessRules;
import com.turkcell.rentacar.core.utilities.exceptions.problemDetails.BusinessProblemDetails;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
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
//AOP aspect orient programming

    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {
        brandBusinessRules.brandNameCanNotBeDuplicated(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        brand.setCreatedDate(LocalDateTime.now());
        Brand createdBrand =  brandRepository.save(brand);
        CreatedBrandResponse createdBrandResponse = this.modelMapperService.forResponse().map(createdBrand,CreatedBrandResponse.class);
        return createdBrandResponse;
    }

    @Override
    public GotBrandResponse getById(int id) {
        brandBusinessRules.brandIdCanNotFound(id);
        Brand brand = this.brandRepository.findById(id).orElse(null);
        return this.modelMapperService.forResponse().map(brand, GotBrandResponse.class);
    }

    @Override
    public List<GotBrandResponse> getAll() {
        List<Brand> brands = this.brandRepository.findAll();
        brandBusinessRules.processActiveBrandsOnly();
        return brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand,GotBrandResponse.class)).collect(Collectors.toList());
    }

    @Override
    public UpdatedBrandResponse update(UpdateBrandRequest updateBrandRequest) {

        brandBusinessRules.brandIdCanNotFound(updateBrandRequest.getId());
        brandBusinessRules.brandNameCanNotBeDuplicated(updateBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        brand.setUpdatedDate(LocalDateTime.now());
        brandRepository.save(brand);
        return this.modelMapperService.forResponse().map(brand,UpdatedBrandResponse.class);
    }

    @Override
    public DeletedBrandResponse delete(int id) {
        brandBusinessRules.brandIdCanNotFound(id);
        Brand brand = this.brandRepository.findById(id).orElse(null);
        brand.setDeleted(true);
        brand.setDeletedDate(LocalDateTime.now());
        return this.modelMapperService.forResponse().map(brand,DeletedBrandResponse.class);


    }


}
