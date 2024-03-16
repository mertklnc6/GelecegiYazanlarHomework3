package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.IService;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/transmissions")
public class TransmissionController {
    private IService<Transmission> service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Transmission add(@RequestBody Transmission transmission)
    {
        return service.add(transmission);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Transmission> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Transmission getById(int id){

        return service.getById(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Transmission update(@RequestBody int id,Transmission transmission){
        try {
            return service.update(id, transmission);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(Transmission transmission){
        service.delete(transmission);
    }
}
