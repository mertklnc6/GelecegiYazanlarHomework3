package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.CarRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.Rental;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
public class RentalBusinessRules {
    private ModelMapperService modelMapperService;
    private CarRepository carRepository;

    public int calculateDailyPrice(Rental rental) {
        int days = (int) ChronoUnit.DAYS.between(rental.getStartDate(), rental.getEndDate());
        Car car = this.carRepository.findById(rental.getCar().getId()).orElse(null); // Arabanın id sini buluyoruz sonra dailyPrice'ını çekiyoruz.
        int result = car.getDailyPrice() * days;

        System.out.println(result);
        return result;

    }
}
