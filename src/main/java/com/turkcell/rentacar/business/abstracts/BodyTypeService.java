package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.bodyTypes.CreateBodyTypeRequest;
import com.turkcell.rentacar.business.dtos.requests.bodyTypes.UpdateBodyTypeRequest;
import com.turkcell.rentacar.business.dtos.responses.bodyTypes.CreatedBodyTypeResponse;
import com.turkcell.rentacar.business.dtos.responses.bodyTypes.DeletedBodyTypeResponse;
import com.turkcell.rentacar.business.dtos.responses.bodyTypes.GotBodyTypeResponse;
import com.turkcell.rentacar.business.dtos.responses.bodyTypes.UpdatedBodyTypeResponse;

import java.util.List;

public interface BodyTypeService {
    public CreatedBodyTypeResponse add(CreateBodyTypeRequest createBodyTypeRequest);
    public GotBodyTypeResponse getById(int id);
    public List<GotBodyTypeResponse> getAll();

    public UpdatedBodyTypeResponse update(UpdateBodyTypeRequest updateBodyTypeRequest);

    public DeletedBodyTypeResponse delete(int id);

}
