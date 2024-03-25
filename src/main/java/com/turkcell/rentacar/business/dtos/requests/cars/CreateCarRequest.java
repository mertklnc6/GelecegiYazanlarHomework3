package com.turkcell.rentacar.business.dtos.requests.cars;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.turkcell.rentacar.entities.concretes.Car;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCarRequest {
    @JsonIgnore
    private int id;
    @NotNull
    private int findexScore;
    @NotNull
    private int modelYear;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 30)
    private String plate;
    @NotNull
    private int state;
    @NotNull
    private int dailyPrice;
    @NotNull
    //Integer olarak tanımlanan field NotBlank Anotation alamaz :)
    private int modelId; //@JoinColumn(name = "model_id") olarak kullandık ancak request kısmında modelId olarak vermediğimizde ilişkiyi yakalayamıyor. :)
}
