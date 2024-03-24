package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.customer.CreateCorporateCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.customer.CreatedCorporateCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.GotCorporateCustomerResponse;

import java.util.List;

public interface CorporateCustomerService {
    CreatedCorporateCustomerResponse add(CreateCorporateCustomerRequest createCorporateCustomerRequest);
    List<GotCorporateCustomerResponse> getAll();



}
