package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "payments")

public class Payment extends BaseEntity {

    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "cardholder")
    private String cardholder;
    @Column(name = "card_expiration_year")
    private int cardExpirationYear;
    @Column(name = "card_expiration_month")
    private int cardExpirationMonth;
    @Column(name = "card_cvv")
    private String cardCvv;
    @Column(name = "balance")
    private double balance;
    @Column(name = "payment_date")
    private LocalDateTime paymentDate;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
