package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.IService;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/brands")
public class BrandsController {

    private IService<Brand> service; //IoC inversion of control

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Brand add(@RequestBody Brand brand)
    {
        return service.add(brand);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Brand> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Brand getById(int id){

        return service.getById(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Brand update(@RequestBody int id,Brand brand){
        try {
            return service.update(id, brand);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(Brand brand){
        service.delete(brand);
    }
}
