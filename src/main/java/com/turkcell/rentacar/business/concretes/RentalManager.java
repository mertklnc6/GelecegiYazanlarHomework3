package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.PaymentService;
import com.turkcell.rentacar.business.abstracts.RentalProductService;
import com.turkcell.rentacar.business.abstracts.RentalService;
import com.turkcell.rentacar.business.dtos.requests.payments.CreatePaymentRequest;
import com.turkcell.rentacar.business.dtos.requests.rental.CreateRentalProductRequest;
import com.turkcell.rentacar.business.dtos.requests.rental.CreateRentalRequest;
import com.turkcell.rentacar.business.dtos.requests.rental.UpdateRentalRequest;
import com.turkcell.rentacar.business.dtos.responses.rental.*;
import com.turkcell.rentacar.business.rules.RentalBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.ProductRepository;
import com.turkcell.rentacar.dataAccess.abstracts.RentalRepository;
import com.turkcell.rentacar.entities.concretes.Payment;
import com.turkcell.rentacar.entities.concretes.Product;
import com.turkcell.rentacar.entities.concretes.Rental;
import com.turkcell.rentacar.entities.concretes.RentalProduct;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    private RentalRepository rentalRepository;
    private ModelMapperService modelMapperService;
    private RentalBusinessRules rentalBusinessRules;
    private PaymentService paymentService;
    private RentalProductService rentalProductService;
    @Override
    public CreatedRentalResponse add(CreateRentalRequest createRentalRequest) {
        Rental rental = this.modelMapperService.forRequest().map(createRentalRequest, Rental.class);

        this.rentalBusinessRules.checkDatesAreCorrect(rental);
        this.rentalBusinessRules.isCarExistById(rental);
        this.rentalBusinessRules.isCarAvailable(rental);
        this.rentalBusinessRules.compareCarAndCustomerFindexScore(rental);
        rental.setTotalPrice(rentalBusinessRules.calculateTotalPriceofRental(rental));


        int totalPrice = this.rentalBusinessRules.checkCustomerBalanceForPayment(rental); //odeme islemi
        Rental rental1 =this.rentalRepository.save(rental);

        this.rentalProductService.add(rental,rental.getProducts());  //Ara Tabloya verileri ekleme

        Payment payment = new Payment(totalPrice,rental);        //Odeme basarili oldugu icin yapilan odemeyi kaydetme
        CreatePaymentRequest createPaymentRequest =this.modelMapperService.forRequest().map(payment, CreatePaymentRequest.class);

        this.paymentService.add(createPaymentRequest);
        return this.modelMapperService.forResponse().map(rental1, CreatedRentalResponse.class);
    }
    @Override
    public List<GetAllRentalResponse> getAll() {
        return this.rentalRepository.findAll().stream().map(rental -> this.modelMapperService.forResponse().
                map(rental, GetAllRentalResponse.class)).collect(Collectors.toList());
    }
    @Override
    public GetByIdRentalResponse getById(int id){
        this.rentalBusinessRules.isRentalExistById(id);
        Rental rental = this.rentalRepository.findById(id).orElse(null);
        return this.modelMapperService.forResponse().map(rental, GetByIdRentalResponse.class);
    }
    @Override
    public UpdatedRentalResponse update(UpdateRentalRequest updateRentalRequest){
        Rental rental = this.modelMapperService.forRequest().map(updateRentalRequest,Rental.class);

        this.rentalBusinessRules.checkDatesAreCorrect(rental);
        this.rentalBusinessRules.isRentalExistById(rental.getId());
        this.rentalBusinessRules.isCarExistById(rental);
        this.rentalBusinessRules.isCarAvailable(rental);
        this.rentalBusinessRules.compareCarAndCustomerFindexScore(rental);

        rental.setTotalPrice(this.rentalBusinessRules.calculateTotalPriceofRental(rental));
        return this.modelMapperService.forResponse().map(this.rentalRepository.save(rental), UpdatedRentalResponse.class);
    }
    @Override
    public DeletedRentalResponse delete(int id){
        this.rentalBusinessRules.isRentalExistById(id);
        this.rentalBusinessRules.isRentalEmptyById(id);

        Rental rental = this.rentalRepository.findById(id).orElse(null);
        rental.setDeletedDate(LocalDateTime.now());
        return this.modelMapperService.forResponse().map(rental, DeletedRentalResponse.class);
    }
}
