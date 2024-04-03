package com.turkcell.rentacar.business.dtos.responses.payments;

import com.turkcell.rentacar.entities.concretes.Product;
import com.turkcell.rentacar.entities.concretes.Rental;
import com.turkcell.rentacar.entities.concretes.RentalProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPaymentResponse {
    private int id;
    private int totalPaymentPrice;
    private int rentalId;
    private int customerId;
    private int carId;
    private List<GetAllRentalProductResponse> products;
}
