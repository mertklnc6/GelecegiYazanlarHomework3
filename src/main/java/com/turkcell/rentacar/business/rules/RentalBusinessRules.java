package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.adapter.FindexService;
import com.turkcell.rentacar.adapter.result.FindexResult;
import com.turkcell.rentacar.business.outService.CreateBankInformationRequest;
import com.turkcell.rentacar.business.messages.CarMessages;
import com.turkcell.rentacar.business.messages.RentalMessages;
import com.turkcell.rentacar.business.outService.BankService;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.CarRepository;
import com.turkcell.rentacar.dataAccess.abstracts.RentalRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.Product;
import com.turkcell.rentacar.entities.concretes.Rental;
import com.turkcell.rentacar.entities.concretes.RentalProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RentalBusinessRules {
    private CarRepository carRepository;
    private FindexService findexService;
    private CarBusinessRules carBusinessRules;
    private RentalRepository rentalRepository;
    private BankService bankService;
    private ProductBusinessRules productBusinessRules;

    public int calculateTotalPriceofRental(Rental rental) {
        int days = (int) ChronoUnit.DAYS.between(rental.getStartDate(), rental.getEndDate());
        Car car = this.carRepository.findById(rental.getCar().getId()).orElse(null);
        return car.getDailyPrice() * days;
    }

    public void isCarAvailable(Rental rental){
        Car car = this.carRepository.findById(rental.getCar().getId()).orElse(null);
        assert car != null;
        if (!(car.getState() == Car.State.Available)){  //1 available 2- maintenance 3- rented
            throw new BusinessException(RentalMessages.CAR_NOT_AVAILABLE);
        }
    }
    public void isCarExistById(Rental rental){
        Optional<Car> car = this.carRepository.findById(rental.getCar().getId());
        this.carBusinessRules.isCarExistById(rental.getCar().getId());
        if (car.isEmpty()){
            throw new BusinessException(CarMessages.CAR_NOT_EXIST);
        }
    }
    public void compareCarAndCustomerFindexScore(Rental rental){
        FindexResult findexResult = this.findexService.getFindexScoreofCustomer(rental.getCustomer().getId());
        Car car = this.carRepository.findById(rental.getCar().getId()).orElse(null);
        if (findexResult.getFindexScore() <= car.getFindexScore()){
            throw new BusinessException(RentalMessages.CUSTOMER_FINDEXSCORE_NOT_ENOUGH);
        }
    }
    public void isRentalExistById(int id){
        Optional<Rental> rental = this.rentalRepository.findById(id);
        if (rental.isEmpty()){
            throw  new BusinessException(RentalMessages.RENTAL_NOT_EXIST);
        }
    }
   public void isRentalEmptyById(int id){
        Optional<Rental> rental = this.rentalRepository.findById(id);
        if (rental.isEmpty()){
            throw new BusinessException(RentalMessages.RENTAL_IS_NULL);
        }
   }
   public void checkDatesAreCorrect(Rental rental){
        if (calculateTotalPriceofRental(rental) < 0){
            throw new BusinessException(RentalMessages.DATES_ARE_INCORRECT);
        }
   }
   public int checkCustomerBalanceForPayment(Rental rental){
       int quantity =0;
       int totalPrice= 0;
       for (RentalProduct product: rental.getProducts()){
          quantity = product.getProduct().getQuantity();
          this.productBusinessRules.checkProductQuantityLimit(quantity,product.getId());   //İstenilen adette var mı ?
          totalPrice += this.productBusinessRules.calculateTotalPriceofProductRequest(quantity,product.getId());  //İstenilen adette varsa adet * fiyatı ver
        }

       int result = ((int) rental.getTotalPrice()+totalPrice);
       if ( ! this.bankService.makePayment(new CreateBankInformationRequest(result
                       ,"5458963231","02","2028","455"))
               .isMakePayment()){
           throw new BusinessException(RentalMessages.PAYMENT_FAILED);
       }

        this.productBusinessRules.reduceQuantityofProductsinStore(rental.getProducts()); //İstenilen adette product odendiyse, depoda olan miktardan ödenilen sayisini cıkar.

       return result;
   }
}
