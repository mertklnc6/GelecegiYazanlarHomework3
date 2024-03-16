package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.IService;
import com.turkcell.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@org.springframework.stereotype.Service
public class TransmissionManager implements IService<Transmission> {

    private TransmissionRepository repository;
    @Override
    public Transmission add(Transmission transmission) {
        Transmission createdTransmission = repository.save(transmission);
        return createdTransmission;
    }

    @Override
    public Transmission update(int id, Transmission transmission) {
        Transmission existingTransmission = repository.getById(id);

        if (existingTransmission != null) {

            Transmission updatedTransmission = repository.save(transmission);
            return updatedTransmission;
        } else {

            try {
                throw new IOException("Varlık bulunamadı");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Transmission> getAll() {
        return repository.findAll();
    }

    @Override
    public Transmission getById(int id) {
        return repository.getById(id);
    }

    @Override
    public void delete(Transmission transmission) {
        repository.delete(transmission);
    }
}
