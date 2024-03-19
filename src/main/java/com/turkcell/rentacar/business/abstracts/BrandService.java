package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.brands.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.brands.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.brands.CreatedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brands.DeletedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brands.GotBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brands.UpdatedBrandResponse;

import java.util.List;

public interface BrandService {
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest);
    public GotBrandResponse getById(int id);
    public List<GotBrandResponse> getAll();

    public UpdatedBrandResponse update(UpdateBrandRequest updateBrandRequest);

    public DeletedBrandResponse delete(int id);

}
