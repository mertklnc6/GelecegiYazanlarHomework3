package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.ProductService;
import com.turkcell.rentacar.business.dtos.requests.product.CreateProductRequest;
import com.turkcell.rentacar.business.dtos.requests.product.UpdateProductRequest;
import com.turkcell.rentacar.business.dtos.responses.product.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/products")
public class ProductsController {
    private ProductService productService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedProductResponse add(@RequestBody CreateProductRequest createProductRequest) {
        return this.productService.add(createProductRequest);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllProductResponse> getAll() {
        return this.productService.getAll();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdProductResponse getById(@PathVariable int id) {
        return this.productService.getById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedProductResponse update(@RequestBody UpdateProductRequest updateProductRequest){
        return this.productService.update(updateProductRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeletedProductResponse delete(@PathVariable int id){
        return this.productService.delete(id);
    }
}
