package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.models.CreateModelRequest;
import com.turkcell.rentacar.business.dtos.requests.models.UpdateModelRequest;
import com.turkcell.rentacar.business.dtos.responses.models.CreatedModelResponse;
import com.turkcell.rentacar.business.dtos.responses.models.DeletedModelResponse;
import com.turkcell.rentacar.business.dtos.responses.models.GotModelResponse;
import com.turkcell.rentacar.business.dtos.responses.models.UpdatedModelResponse;

import java.util.List;

public interface ModelService {
    public CreatedModelResponse add(CreateModelRequest createModelRequest);
    public GotModelResponse getById(int id);
    public List<GotModelResponse> getAll();

    public UpdatedModelResponse update(UpdateModelRequest updateModelRequest);

    public DeletedModelResponse delete(int id);

}
