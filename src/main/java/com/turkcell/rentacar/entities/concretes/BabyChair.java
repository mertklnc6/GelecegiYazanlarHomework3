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
@Table(name = "baby_chairs")
public class BabyChair extends Product{
    private String ageLimit;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private  Product product;
}
