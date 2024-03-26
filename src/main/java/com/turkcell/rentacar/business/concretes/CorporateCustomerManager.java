package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.CorporateCustomerService;
import com.turkcell.rentacar.business.dtos.requests.customer.CreateCorporateCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.customer.CreatedCorporateCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.CreatedIndividualCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.GotCorporateCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.GotIndividualCustomerResponse;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.CorporateCustomerRepository;
import com.turkcell.rentacar.entities.concretes.CorporateCustomer;
import com.turkcell.rentacar.entities.concretes.IndividualCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class CorporateCustomerManager implements CorporateCustomerService {
    private CorporateCustomerRepository corporateCustomerRepository;
    private ModelMapperService modelMapperService;
    @Override
    public CreatedCorporateCustomerResponse add(CreateCorporateCustomerRequest createCorporateCustomerRequest) {
        CorporateCustomer corporateCustomer = this.modelMapperService.forRequest().map(createCorporateCustomerRequest,CorporateCustomer.class);
        corporateCustomer.setCreatedDate(LocalDateTime.now());
        CorporateCustomer saveCustomer = this.corporateCustomerRepository.save(corporateCustomer);
        return this.modelMapperService.forResponse().map(saveCustomer, CreatedCorporateCustomerResponse.class);
    }
    @Override
    public List<GotCorporateCustomerResponse> getAll() {
        List<CorporateCustomer> corporateCustomerList = this.corporateCustomerRepository.findAll();
        return corporateCustomerList.stream().map(corporateCustomer ->
                this.modelMapperService.forResponse().map(corporateCustomer, GotCorporateCustomerResponse.class)).collect(Collectors.toList());
    }
}
