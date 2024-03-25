package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.adapter.FindexServiceAdapter;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
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
    private FindexServiceAdapter findexServiceAdapter;

    public int calculateDailyPrice(Rental rental) {
        int days = (int) ChronoUnit.DAYS.between(rental.getStartDate(), rental.getEndDate());
        Car car = this.carRepository.findById(rental.getCar().getId()).orElse(null); // Arabanın id sini buluyoruz sonra dailyPrice'ını çekiyoruz.
        int result = car.getDailyPrice() * days;
        System.out.println(result);
        return result;
    }

    public void isAvailable(Rental rental){
        Car car = this.carRepository.findById(rental.getCar().getId()).orElse(null);
        assert car != null;
        if (!(car.getState() ==1)){  //1 available 2- maintenance 3- rented
            throw new BusinessException("Car Does not Available now!");
        }
    }
    public void findexControl(Rental rental){
        int customerFindex = this.findexServiceAdapter.getFindexScore(rental.getCustomer().getId());
        System.out.println(customerFindex);
        Car car = this.carRepository.findById(rental.getCar().getId()).orElse(null);
        int result = car.getFindexScore();
        if (customerFindex <= result){
            throw new BusinessException("Findex skoru yetersiz. Baska bir aracla deneyiniz.");
        }
    }
}
