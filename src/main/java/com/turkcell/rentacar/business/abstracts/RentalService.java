package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.rental.CreateRentalRequest;
import com.turkcell.rentacar.business.dtos.responses.rental.CreatedRentalResponse;
import com.turkcell.rentacar.business.dtos.responses.rental.GotRentalResponse;

import java.util.List;

public interface RentalService {
    CreatedRentalResponse add(CreateRentalRequest createRentalRequest);
    List<GotRentalResponse> getAll();
}
