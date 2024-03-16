package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.IService;
import com.turkcell.rentacar.dataAccess.abstracts.FuelRepository;
import com.turkcell.rentacar.entities.concretes.Fuel;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@org.springframework.stereotype.Service
public class FuelManager implements IService<Fuel> {

    private FuelRepository repository;
    @Override
    public Fuel add(Fuel fuel) {
        Fuel createdFuel = repository.save(fuel);
        return createdFuel;
    }

    @Override
    public Fuel update(int id, Fuel fuel) {
        Fuel existingFuel = repository.getById(id);

        if (existingFuel != null) {

            Fuel updatedFuel = repository.save(fuel);
            return updatedFuel;
        } else {

            try {
                throw new IOException("Varlık bulunamadı");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Fuel> getAll() {
        return repository.findAll();
    }

    @Override
    public Fuel getById(int id) {
        return repository.getById(id);
    }

    @Override
    public void delete(Fuel fuel) {
        repository.delete(fuel);
    }
}
