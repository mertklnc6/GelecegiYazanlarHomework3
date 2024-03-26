package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.IndividualCustomerService;
import com.turkcell.rentacar.business.dtos.requests.customer.CreateIndividualCustomerRequest;
import com.turkcell.rentacar.business.dtos.requests.customer.UpdateIndividualCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.customer.CreatedIndividualCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.DeletedIndividualCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.GotIndividualCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.UpdatedIndividualCustomerResponse;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.IndividualCustomerRepository;
import com.turkcell.rentacar.entities.concretes.IndividualCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class IndividualCustomerManager implements IndividualCustomerService {
    private IndividualCustomerRepository individualCustomerRepository;
    private ModelMapperService modelMapperService;
    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        IndividualCustomer individualCustomer = this.modelMapperService.forRequest().map(createIndividualCustomerRequest,IndividualCustomer.class);
        individualCustomer.setCreatedDate(LocalDateTime.now());
        IndividualCustomer saveCustomer = this.individualCustomerRepository.save(individualCustomer);
        return this.modelMapperService.forResponse().map(saveCustomer, CreatedIndividualCustomerResponse.class);

    }
    @Override
    public List<GotIndividualCustomerResponse> getAll() {
        List<IndividualCustomer> individualCustomerList = this.individualCustomerRepository.findAll();
        return individualCustomerList.stream().map(individualCustomer ->
                this.modelMapperService.forResponse().map(individualCustomer,GotIndividualCustomerResponse.class)).collect(Collectors.toList());
    }
    @Override
    public GotIndividualCustomerResponse getById(int id) {
        return null;
    }
    @Override
    public UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
        return null;
    }
    @Override
    public DeletedIndividualCustomerResponse delete(int id) {
        return null;
    }
}
