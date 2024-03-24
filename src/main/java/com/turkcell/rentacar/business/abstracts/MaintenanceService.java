package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.maintenance.CreateMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.requests.maintenance.UpdateMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.responses.maintenance.CreatedMaintenanceResponse;
import com.turkcell.rentacar.business.dtos.responses.maintenance.DeletedMaintenanceResponse;
import com.turkcell.rentacar.business.dtos.responses.maintenance.GotMaintenanceResponse;
import com.turkcell.rentacar.business.dtos.responses.maintenance.UpdatedMaintenanceResponse;

import java.util.List;

public interface MaintenanceService {

    CreatedMaintenanceResponse add(CreateMaintenanceRequest createMaintenanceRequest);

    List<GotMaintenanceResponse> getAll();

    UpdatedMaintenanceResponse update(UpdateMaintenanceRequest updateMaintenanceRequest);

    GotMaintenanceResponse getById(int id);

    DeletedMaintenanceResponse delete(int id);


}
