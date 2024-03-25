package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.MaintenanceService;
import com.turkcell.rentacar.business.dtos.requests.maintenance.CreateMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.requests.maintenance.UpdateMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.responses.maintenance.CreatedMaintenanceResponse;
import com.turkcell.rentacar.business.dtos.responses.maintenance.DeletedMaintenanceResponse;
import com.turkcell.rentacar.business.dtos.responses.maintenance.GotMaintenanceResponse;
import com.turkcell.rentacar.business.dtos.responses.maintenance.UpdatedMaintenanceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/maintenances")
@RequiredArgsConstructor
public class MaintenancesController {
    private final MaintenanceService maintenanceService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedMaintenanceResponse add(@RequestBody CreateMaintenanceRequest createMaintenanceRequest){
        return this.maintenanceService.add(createMaintenanceRequest);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GotMaintenanceResponse> getAll(){
        return this.maintenanceService.getAll();
    }
    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GotMaintenanceResponse getById(@PathVariable int id){
        return this.maintenanceService.getById(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedMaintenanceResponse update(@RequestBody UpdateMaintenanceRequest updateMaintenanceRequest){
        return this.maintenanceService.update(updateMaintenanceRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeletedMaintenanceResponse delete(@PathVariable int id){
        return this.maintenanceService.delete(id);
    }

}
