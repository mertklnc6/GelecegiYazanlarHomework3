package com.turkcell.rentacar.business.rules;


import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.CarRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CarBusinessRules {

    private CarRepository carRepository;

    public void checkCarIdExist(int id){
        if(!this.carRepository.existsById(id)){
            throw new BusinessException("CarNotExists");
        }
    }
}