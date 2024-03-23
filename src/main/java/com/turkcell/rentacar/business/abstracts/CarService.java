package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.cars.CreateCarRequest;
import com.turkcell.rentacar.business.dtos.requests.cars.UpdateCarRequest;
import com.turkcell.rentacar.business.dtos.responses.cars.CreatedCarResponse;
import com.turkcell.rentacar.business.dtos.responses.cars.DeletedCarResponse;
import com.turkcell.rentacar.business.dtos.responses.cars.GotCarResponse;
import com.turkcell.rentacar.business.dtos.responses.cars.UpdatedCarResponse;

import java.util.List;

public interface CarService {

    public CreatedCarResponse add(CreateCarRequest createCarRequest);
    public GotCarResponse getById(int id);
    public List<GotCarResponse> getAll();

    public UpdatedCarResponse update(UpdateCarRequest updateCarRequest);

    public DeletedCarResponse delete(int id);
}
