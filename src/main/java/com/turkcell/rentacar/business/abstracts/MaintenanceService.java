package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.maintenance.CreateMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.responses.maintenance.CreatedMaintenanceResponse;

import java.util.List;

public interface MaintenanceService {

    CreatedMaintenanceResponse add(CreateMaintenanceRequest createMaintenanceRequest);

   List<CreatedMaintenanceResponse> getAll();
}
