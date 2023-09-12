package com.wallet.tx_ms.models;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "PAYMENT")
public class PaymentModel {

    @Id
    @GeneratedValue
    private UUID id_payment;

    @Column(nullable = false)
    private float amount;

    @Column(nullable = false)
    private LocalDateTime datetime;

    @Column(nullable = false, length = 1)
    private char state;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private UserModel id_user;

    public UUID getId_payment() {
        return id_payment;
    }

    public void setId_payment(UUID id_payment) {
        this.id_payment = id_payment;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = LocalDateTime.now();
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = 'A';
    }

    public UserModel getId_user() {
        return id_user;
    }

    public void setId_user(UserModel id_user) {
        this.id_user = id_user;
    }


}
