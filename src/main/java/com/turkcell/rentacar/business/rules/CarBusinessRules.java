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
    public void isCarExistById(int id){
        if(this.carRepository.findById(id).isEmpty()){
            throw new BusinessException("Car Does not Exist");
        }
    }
    public Car.State setCarStatefromIntegertoEnum(int stateId){
        for (Car.State state: Car.State.values()){
            if (state.getValue() == stateId){
                return state;
            }
        }
        throw new BusinessException("Invalid State Value");
    }
}