package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.fuels.CreateFuelRequest;
import com.turkcell.rentacar.business.dtos.requests.fuels.UpdateFuelRequest;
import com.turkcell.rentacar.business.dtos.responses.fuels.CreatedFuelResponse;
import com.turkcell.rentacar.business.dtos.responses.fuels.DeletedFuelResponse;
import com.turkcell.rentacar.business.dtos.responses.fuels.GotFuelResponse;
import com.turkcell.rentacar.business.dtos.responses.fuels.UpdatedFuelResponse;

import java.util.List;

public interface FuelService {
    public CreatedFuelResponse add(CreateFuelRequest createFuelRequest);
    public GotFuelResponse getById(int id);
    public List<GotFuelResponse> getAll();

    public UpdatedFuelResponse update(UpdateFuelRequest updateFuelRequest);

    public DeletedFuelResponse delete(int id);

}
