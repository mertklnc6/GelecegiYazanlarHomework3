package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.MaintenanceService;
import com.turkcell.rentacar.business.dtos.requests.maintenance.CreateMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.requests.maintenance.UpdateMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.responses.maintenance.CreatedMaintenanceResponse;
import com.turkcell.rentacar.business.dtos.responses.maintenance.DeletedMaintenanceResponse;
import com.turkcell.rentacar.business.dtos.responses.maintenance.GotMaintenanceResponse;
import com.turkcell.rentacar.business.dtos.responses.maintenance.UpdatedMaintenanceResponse;
import com.turkcell.rentacar.business.rules.CarBusinessRules;
import com.turkcell.rentacar.business.rules.MaintenanceBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.MaintenanceRepository;
import com.turkcell.rentacar.entities.concretes.Maintenance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class MaintenanceManager implements MaintenanceService {
    private final CarBusinessRules carBusinessRules;
    private final ModelMapperService modelMapperService;
    private final MaintenanceRepository maintenanceRepository;
    private final MaintenanceBusinessRules maintenanceBusinessRules;


    @Override
    public CreatedMaintenanceResponse add( CreateMaintenanceRequest createMaintenanceRequest) {

        //buradaki business kurallarına arabanın kiralanıp kiralanmadıgıda business rules olarak kontrol edilcek
        carBusinessRules.checkCarIdExist(createMaintenanceRequest.getCarId());
        maintenanceBusinessRules.checkIfCarInMaintenance(createMaintenanceRequest.getCarId());


        Maintenance maintenance =
                this.modelMapperService.forRequest().map(createMaintenanceRequest,Maintenance.class);


        maintenance.setDateSent(LocalDateTime.now());

        this.maintenanceRepository.save(maintenance);

        CreatedMaintenanceResponse createdMaintenanceResponse =
                this.modelMapperService.forResponse().map(maintenance, CreatedMaintenanceResponse.class);

        return createdMaintenanceResponse;
    }

    @Override
    public List<GotMaintenanceResponse>  getAll() {
        List<Maintenance> maintenanceList = this.maintenanceRepository.findAll();

        return maintenanceList.stream().map(maintenance -> this.modelMapperService.forResponse().
                map(maintenance, GotMaintenanceResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GotMaintenanceResponse getById(int id) {
        Maintenance maintenance = this.maintenanceRepository.findById(id).orElse(null);
        return modelMapperService.forResponse().map(maintenance, GotMaintenanceResponse.class);
    }


    @Override
    public UpdatedMaintenanceResponse update(UpdateMaintenanceRequest updateMaintenanceRequest) {
        maintenanceBusinessRules.checkIfMaintenanceExist(updateMaintenanceRequest.getId());
        Maintenance maintenance = this.modelMapperService.forRequest().map(updateMaintenanceRequest, Maintenance.class);
        maintenance.setDateReturned(LocalDateTime.now());

        Maintenance updatedMaintenance = maintenanceRepository.save(maintenance);

        return this.modelMapperService.forResponse().map(updatedMaintenance, UpdatedMaintenanceResponse.class);
    }

    @Override
    public DeletedMaintenanceResponse delete(int id) {
        maintenanceBusinessRules.checkIfMaintenanceExist(id);
        Maintenance maintenance = this.maintenanceRepository.findById(id).orElse(null);
        maintenance.setDeletedDate(LocalDateTime.now());
        return modelMapperService.forResponse().map(maintenance, DeletedMaintenanceResponse.class);
    }
}
