package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.CarRepository;
import com.turkcell.rentacar.dataAccess.abstracts.MaintenanceRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.Maintenance;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MaintenanceBusinessRules {
    private final MaintenanceRepository maintenanceRepository;
    private CarRepository carRepository;
    public void checkIfCarInMaintenance(int carId){

        Car car = this.carRepository.findById(carId).orElse(null);
        assert car != null;
        if (!(car.getState() == 1 )){
            throw new BusinessException("the car is already in maintenance");
        }
    }

    public void checkIfMaintenanceExist(int maintenanceId){
        Optional<Maintenance> maintenance = maintenanceRepository.findById(maintenanceId);

        if(!maintenance.isPresent()){
            throw new BusinessException("The maintenance does not exist");
        }
    }
}
