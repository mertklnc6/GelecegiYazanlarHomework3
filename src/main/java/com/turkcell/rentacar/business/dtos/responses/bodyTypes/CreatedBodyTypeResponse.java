package com.turkcell.rentacar.business.dtos.responses.bodyTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedBodyTypeResponse {
    private int id;
    private String name;
    private LocalDateTime createdDate;
}
