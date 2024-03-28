package com.turkcell.rentacar.entities.concretes;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.turkcell.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "rentals")
public class Rental extends BaseEntity {

    private double totalPrice;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @OneToOne(mappedBy = "rental", cascade = CascadeType.ALL) // bağlı olduğu nesnede yapılan değişiklikleri hepsine uygulayıp kaydeder
    private Payment payment;

    @ManyToMany
    private List<ExtraService> extraServices;
    //istediğimiz ara tablo rental_extra_service tablosu oluştu. Ancak best practice mi? :)
}
