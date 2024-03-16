package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.IService;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements IService<Brand> {

    private BrandRepository repository;
    @Override
    public Brand add(Brand brand) {
        Brand createdBrand = repository.save(brand);
        return createdBrand;
    }

    @Override
    public Brand update(int id, Brand brand) {
        Brand existingBrand = repository.getById(id);

        if (existingBrand != null) {

            Brand updatedBrand = repository.save(brand);
            return updatedBrand;
        } else {

            try {
                throw new IOException("Varlık bulunamadı");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Brand> getAll() {
        return repository.findAll();
    }

    @Override
    public Brand getById(int id) {
        return repository.getById(id);
    }

    @Override
    public void delete(Brand brand) {
        repository.delete(brand);
    }
}
