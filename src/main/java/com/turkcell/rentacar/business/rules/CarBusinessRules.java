package com.turkcell.rentacar.business.rules;


import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.CarRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarBusinessRules {

    private final CarRepository carRepository;

    public void checkCarIdExist(int id){

        Optional<Car> car =  this.carRepository.findById(id);

        if(!car.isPresent()){
            throw new BusinessException("CarNotExists");
        }

    }
}