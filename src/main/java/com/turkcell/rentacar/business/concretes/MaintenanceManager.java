package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.MaintenanceService;
import com.turkcell.rentacar.business.dtos.requests.maintenance.CreateMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.responses.maintenance.CreatedMaintenanceResponse;
import com.turkcell.rentacar.business.rules.CarBusinessRules;
import com.turkcell.rentacar.business.rules.MaintenanceBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.MaintenanceRepository;
import com.turkcell.rentacar.entities.concretes.Maintenance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

        //Optional<Car>  setCar = this.carRepository.findById(createMaintenanceRequest.getCarId());
        //maintenance.setCar(setCar.get());

        this.maintenanceRepository.save(maintenance);

        CreatedMaintenanceResponse createdMaintenanceResponse =
                this.modelMapperService.forResponse().map(maintenance, CreatedMaintenanceResponse.class);

        return createdMaintenanceResponse;
    }

    @Override
    public List<CreatedMaintenanceResponse>  getAll() {
        List<Maintenance> maintenanceList = this.maintenanceRepository.findAll();

        return maintenanceList.stream().map(maintenance -> this.modelMapperService.forResponse().
                map(maintenance, CreatedMaintenanceResponse.class)).collect(Collectors.toList());
    }


}
