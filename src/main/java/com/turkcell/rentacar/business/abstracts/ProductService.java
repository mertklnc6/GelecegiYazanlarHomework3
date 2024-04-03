package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.product.CreateProductRequest;
import com.turkcell.rentacar.business.dtos.requests.product.UpdateProductRequest;
import com.turkcell.rentacar.business.dtos.responses.product.*;

import java.util.List;

public interface ProductService {
    CreatedProductResponse add(CreateProductRequest createProductRequest);

    List<GetAllProductResponse> getAll();

    GetByIdProductResponse getById(int id);

    UpdatedProductResponse update(UpdateProductRequest updateProductRequest);
    DeletedProductResponse delete(int id);
}
