package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.IService;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@org.springframework.stereotype.Service
public class ModelManager implements IService<Model> {

    private ModelRepository repository;
    @Override
    public Model add(Model model) {
        Model createdModel = repository.save(model);
        return createdModel;
    }

    @Override
    public Model update(int id, Model model) {
        Model existingModel = repository.getById(id);

        if (existingModel != null) {

            Model updatedModel = repository.save(model);
            return updatedModel;
        } else {

            try {
                throw new IOException("Varlık bulunamadı");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Model> getAll() {
        return repository.findAll();
    }

    @Override
    public Model getById(int id) {
        return repository.getById(id);
    }

    @Override
    public void delete(Model model) {
        repository.delete(model);
    }
}
