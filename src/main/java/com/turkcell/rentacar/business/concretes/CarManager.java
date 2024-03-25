package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.CarService;
import com.turkcell.rentacar.business.dtos.requests.cars.CreateCarRequest;
import com.turkcell.rentacar.business.dtos.requests.cars.UpdateCarRequest;
import com.turkcell.rentacar.business.dtos.responses.cars.CreatedCarResponse;
import com.turkcell.rentacar.business.dtos.responses.cars.DeletedCarResponse;
import com.turkcell.rentacar.business.dtos.responses.cars.GotCarResponse;
import com.turkcell.rentacar.business.dtos.responses.cars.UpdatedCarResponse;

import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.CarRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CarManager implements CarService {

    private CarRepository carRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreatedCarResponse add(CreateCarRequest createCarRequest) {
        Car car = this.modelMapperService.forRequest().map(createCarRequest,Car.class);
        car.setCreatedDate(LocalDateTime.now());
        Car createdCar = this.carRepository.save(car);
        return this.modelMapperService.forResponse().map(createdCar,CreatedCarResponse.class);
    }

    @Override
    public GotCarResponse getById(int id) {
        Car car = this.carRepository.findById(id).orElse(null);
        return this.modelMapperService.forResponse().map(car, GotCarResponse.class);
    }

    @Override
    public List<GotCarResponse> getAll() {
        List<Car> cars = this.carRepository.findAll();
        return cars.stream().map(car -> this.modelMapperService.forResponse().map(car,GotCarResponse.class)).collect(Collectors.toList());
    }

    @Override
    public UpdatedCarResponse update(UpdateCarRequest updateCarRequest) {

        Car car = this.modelMapperService.forRequest().map(updateCarRequest,Car.class);
        car.setUpdatedDate(LocalDateTime.now());
        carRepository.save(car);
        return this.modelMapperService.forResponse().map(car,UpdatedCarResponse.class);
    }

    @Override
    public DeletedCarResponse delete(int id) {
        Car car = this.carRepository.findById(id).orElse(null);
        car.setDeletedDate(LocalDateTime.now());
        return this.modelMapperService.forResponse().map(car,DeletedCarResponse.class);

    }


}
