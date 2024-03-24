package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.MaintenanceService;
import com.turkcell.rentacar.business.dtos.requests.maintenance.CreateMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.responses.maintenance.CreatedMaintenanceResponse;
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
    public ResponseEntity<CreatedMaintenanceResponse> add(@RequestBody CreateMaintenanceRequest createMaintenanceRequest){

        return new ResponseEntity<>(this.maintenanceService.add(createMaintenanceRequest), HttpStatus.OK);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CreatedMaintenanceResponse>> getAll(){
        return new ResponseEntity<>(this.maintenanceService.getAll(),HttpStatus.OK );
    }


}
