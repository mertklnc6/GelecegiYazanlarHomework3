package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.ProductService;
import com.turkcell.rentacar.business.dtos.requests.product.CreateProductRequest;
import com.turkcell.rentacar.business.dtos.requests.product.UpdateProductRequest;
import com.turkcell.rentacar.business.dtos.responses.product.*;
import com.turkcell.rentacar.business.rules.ProductBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.ProductRepository;
import com.turkcell.rentacar.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private ProductRepository productRepository;
    private ModelMapperService modelMapperService;
    private ProductBusinessRules productBusinessRules;

    @Override
    public CreatedProductResponse add(CreateProductRequest createProductRequest) {
        productBusinessRules.productNameCanNotBeDuplicated(createProductRequest.getName());
        Product product = this.modelMapperService.forRequest().map(createProductRequest, Product.class);
        product.setCreatedDate(LocalDateTime.now());


        Product createProduct = this.productRepository.save(product);
        return this.modelMapperService.forResponse().map(createProduct, CreatedProductResponse.class);
    }

    @Override
    public List<GetAllProductResponse> getAll() {
        List<Product> products = this.productRepository.findAll();
        return products.stream().map(product -> this.modelMapperService.forResponse()
                .map(product, GetAllProductResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetByIdProductResponse getById(int id) {
        Product product = this.productRepository.findById(id).orElse(null);
        productBusinessRules.isProductExistById(product.getId());

        return this.modelMapperService.forResponse()
                .map(product, GetByIdProductResponse.class);
    }

    @Override
    public UpdatedProductResponse update(UpdateProductRequest updateProductRequest) {
        Product product = this.productRepository.findById(updateProductRequest.getId()).orElse(null);
        this.productBusinessRules.isProductExistById(updateProductRequest.getId());
        product.setUpdatedDate(LocalDateTime.now());
        this.productRepository.save(product);

        return this.modelMapperService.forResponse().map(product, UpdatedProductResponse.class);
    }

    @Override
    public DeletedProductResponse delete(int id) {
        Product product = this.productRepository.findById(id).orElse(null);
        this.productBusinessRules.isProductExistById(id);
        product.setDeletedDate(LocalDateTime.now());
        return this.modelMapperService.forResponse().map(product, DeletedProductResponse.class);
    }
}
