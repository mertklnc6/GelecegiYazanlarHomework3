package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.IService;
import com.turkcell.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/models")
public class ModelController {
    private IService<Model> service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Model add(@RequestBody Model model)
    {
        return service.add(model);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Model> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Model getById(int id){

        return service.getById(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Model update(@RequestBody int id,Model model){
        try {
            return service.update(id, model);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(Model model){
        service.delete(model);
    }
}
