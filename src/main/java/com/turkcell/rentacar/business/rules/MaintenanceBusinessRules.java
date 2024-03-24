package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.MaintenanceRepository;
import com.turkcell.rentacar.entities.concretes.Maintenance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaintenanceBusinessRules {
    private final MaintenanceRepository maintenanceRepository;

    public void checkIfCarInMaintenance(int carId){

        Optional<Maintenance> maintenance=  maintenanceRepository.getByCar_Id(carId);

        if (maintenance.isPresent() && maintenance.get().getDateReturned() == null){
            throw new BusinessException("the car is already in maintenance");
        }

    }
}
