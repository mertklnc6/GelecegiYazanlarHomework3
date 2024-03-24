package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.dtos.requests.brands.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.brands.GetBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.brands.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.brands.CreatedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brands.DeletedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brands.GotBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brands.UpdatedBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/brands")
public class BrandsController {

    private BrandService brandService; //IoC inversion of control


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedBrandResponse add(@Valid @RequestBody CreateBrandRequest createBrandRequest) {
        return brandService.add(createBrandRequest);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GotBrandResponse> getAll() {
        return brandService.getAll();
    }

    //
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GotBrandResponse getById(@PathVariable int id) {

        return brandService.getById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedBrandResponse update(@Valid @RequestBody UpdateBrandRequest updateBrandRequest) {
        return brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeletedBrandResponse delete(@PathVariable int id) {
        return brandService.delete(id);
    }
}
