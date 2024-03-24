package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.CarService;
import com.turkcell.rentacar.business.dtos.requests.cars.CreateCarRequest;
import com.turkcell.rentacar.business.dtos.requests.cars.UpdateCarRequest;
import com.turkcell.rentacar.business.dtos.responses.cars.CreatedCarResponse;
import com.turkcell.rentacar.business.dtos.responses.cars.DeletedCarResponse;
import com.turkcell.rentacar.business.dtos.responses.cars.GotCarResponse;
import com.turkcell.rentacar.business.dtos.responses.cars.UpdatedCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/cars")
public class CarsController {
    private CarService carService; //IoC inversion of control


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCarResponse add(@Valid @RequestBody CreateCarRequest createCarRequest) {
        return carService.add(createCarRequest);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GotCarResponse> getAll() {
        return carService.getAll();
    }

    //
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GotCarResponse getById(@PathVariable int id) {

        return carService.getById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedCarResponse update(@Valid @RequestBody UpdateCarRequest updateCarRequest) {
        return carService.update(updateCarRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeletedCarResponse delete(@PathVariable int id) {
        return carService.delete(id);
    }
}
