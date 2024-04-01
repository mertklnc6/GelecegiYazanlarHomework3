package com.turkcell.rentacar.entities.concretes;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "scooters")
public class Scooter extends Product{
    private int speedLimit;
    private int batteryPower;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private  Product product;
}
