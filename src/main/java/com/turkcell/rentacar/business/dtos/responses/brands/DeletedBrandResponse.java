package com.turkcell.rentacar.business.dtos.responses.brands;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeletedBrandResponse {
    private int id;
    private boolean isDeleted;
    private LocalDateTime deletedDate;
}
