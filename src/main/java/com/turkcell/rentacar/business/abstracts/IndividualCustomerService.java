package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.customer.CreateIndividualCustomerRequest;
import com.turkcell.rentacar.business.dtos.requests.customer.UpdateIndividualCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.customer.CreatedIndividualCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.DeletedIndividualCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.GotIndividualCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.UpdatedIndividualCustomerResponse;

import java.util.List;

public interface IndividualCustomerService {
    CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest);
    List<GotIndividualCustomerResponse> getAll();
    GotIndividualCustomerResponse getById(int id);
    UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest);
    DeletedIndividualCustomerResponse delete(int id);

}
