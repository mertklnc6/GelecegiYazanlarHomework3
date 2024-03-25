package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.RentalService;
import com.turkcell.rentacar.business.dtos.requests.rental.CreateRentalRequest;
import com.turkcell.rentacar.business.dtos.responses.rental.CreatedRentalResponse;
import com.turkcell.rentacar.business.dtos.responses.rental.GotRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/rental")
public class RentalsController {
    private RentalService rentalService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedRentalResponse add(@RequestBody CreateRentalRequest createRentalRequest){
        return rentalService.add(createRentalRequest);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GotRentalResponse> getAll(){
        return rentalService.getAll();
    }
}
