package com.turkcell.rentacar.business.dtos.requests.rental;

import com.turkcell.rentacar.entities.concretes.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateRentalRequest {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int customerId;
    private int carId;
    private List<CreateRentalProductRequest> products;
}
