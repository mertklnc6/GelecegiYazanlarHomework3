package com.turkcell.rentacar.business.dtos.responses.rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllRentalResponse {
    private int id;
    private int totalPrice;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int customerId;
    private int carId;
}

