package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.IService;
import com.turkcell.rentacar.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fuels")
public class FuelController {
    private IService<Fuel> service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Fuel add(@RequestBody Fuel fuel)
    {
        return service.add(fuel);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Fuel> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Fuel getById(int id){

        return service.getById(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Fuel update(@RequestBody int id,Fuel fuel){
        try {
            return service.update(id, fuel);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(Fuel fuel){
        service.delete(fuel);
    }
}