package com.turkcell.rentacar.business.dtos.requests.cars;

import com.turkcell.rentacar.entities.concretes.Car;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCarRequest {
    private int id;
    @NotNull
    @Size(min=2, max=30)
    private String name;
    @NotNull
    private int modelYear;
    @NotNull
    @Size(min = 2, max = 30)
    private String plate;
    @NotNull
    private int state;
    @NotNull
    private double dailyPrice;
    @NotNull
    private int modelId;
}
