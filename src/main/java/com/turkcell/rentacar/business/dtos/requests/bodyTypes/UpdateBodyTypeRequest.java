package com.turkcell.rentacar.business.dtos.requests.bodyTypes;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBodyTypeRequest {
    private int id;
    @NotNull
    private String name;
}
