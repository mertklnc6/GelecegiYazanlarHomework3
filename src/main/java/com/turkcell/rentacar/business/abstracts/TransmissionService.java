package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.transmissions.CreateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.requests.transmissions.UpdateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.responses.transmissions.CreatedTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.transmissions.DeletedTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.transmissions.GotTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.transmissions.UpdatedTransmissionResponse;

import java.util.List;

public interface TransmissionService {
    public CreatedTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest);
    public GotTransmissionResponse getById(int id);
    public List<GotTransmissionResponse> getAll();

    public UpdatedTransmissionResponse update(UpdateTransmissionRequest updateTransmissionRequest);

    public DeletedTransmissionResponse delete(int id);

}
