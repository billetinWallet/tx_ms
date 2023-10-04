package com.wallet.tx_ms.models;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "RECHARGE")
public class RechargeModel {

    @Id
    @GeneratedValue
    private UUID id_recharge;

    @Column(nullable = false)
    private float amount;

    @Column(nullable = false)
    private LocalDateTime datetime;

    @Column(nullable = false, length = 1)
    private char state;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private UserModel id_user;

    public UUID getId_recharge() {
        return id_recharge;
    }

    public void setId_recharge(UUID id_recharge) {
        this.id_recharge = id_recharge;
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
        this.state = state;
    }

    public UserModel getId_user() {
        return id_user;
    }

    public void setId_user(UserModel id_user) {
        this.id_user = id_user;
    }
}
