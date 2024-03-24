package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.RentalService;
import com.turkcell.rentacar.business.dtos.requests.rental.CreateRentalRequest;
import com.turkcell.rentacar.business.dtos.responses.rental.CreatedRentalResponse;
import com.turkcell.rentacar.business.dtos.responses.rental.GotRentalResponse;
import com.turkcell.rentacar.business.rules.RentalBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.RentalRepository;
import com.turkcell.rentacar.entities.concretes.Rental;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    private RentalRepository rentalRepository;
    private ModelMapperService modelMapperService;
    private RentalBusinessRules rentalBusinessRules;

    @Override
    public CreatedRentalResponse add(CreateRentalRequest createRentalRequest) {
        Rental rental = this.modelMapperService.forRequest().map(createRentalRequest, Rental.class);

        rental.setTotalPrice(rentalBusinessRules.calculateDailyPrice(rental));
        CreatedRentalResponse createdRentalResponse = this.modelMapperService.forResponse().map(this.rentalRepository.save(rental), CreatedRentalResponse.class);
        return createdRentalResponse;


    }

    @Override
    public List<GotRentalResponse> getAll() {
        List<Rental> rentalList = rentalRepository.findAll();
        return rentalList.stream().map(rental -> this.modelMapperService.forResponse().map(rental,GotRentalResponse.class)).collect(Collectors.toList());
    }
}
