package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.adapter.FindexService;
import com.turkcell.rentacar.adapter.FindexServiceAdapter;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.CarRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.Rental;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
public class RentalBusinessRules {
    private CarRepository carRepository;
    private FindexService findexService;

    public int calculateDailyPrice(Rental rental) {
        int days = (int) ChronoUnit.DAYS.between(rental.getStartDate(), rental.getEndDate());
        Car car = this.carRepository.findById(rental.getCar().getId()).orElse(null);
        return car.getDailyPrice() * days;
    }

    public void isAvailable(Rental rental){
        Car car = this.carRepository.findById(rental.getCar().getId()).orElse(null);
        assert car != null;
        if (!(car.getState() == Car.State.Available)){  //1 available 2- maintenance 3- rented
            throw new BusinessException("Car Does not Available now!");
        }
    }
    public void findexControl(Rental rental){
        int customerFindex = this.findexService.getFindexScore(rental.getCustomer().getId());

        Car car = this.carRepository.findById(rental.getCar().getId()).orElse(null);
        int result = car.getFindexScore();
        if (customerFindex <= result){
            throw new BusinessException("Findex skoru yetersiz. Baska bir aracla deneyiniz.");
        }
    }
}
