package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    private String color;
    private double price;

    @OneToMany(mappedBy = "product")
    private List<Scooter> scooters;

    @OneToMany(mappedBy = "product")
    private List<BabyChair> babyChairs;
}
