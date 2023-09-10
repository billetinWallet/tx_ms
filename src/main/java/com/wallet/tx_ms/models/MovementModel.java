package com.wallet.tx_ms.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "MOVEMENT")
public class MovementModel {
    @Id
    @GeneratedValue
    private UUID id_movement;

    @Column(nullable = false)
    private float amount;

    @Column(nullable = false)
    private LocalDateTime datetime;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private UserModel id_user;

    @ManyToOne
    @JoinColumn(name = "transaction_type", nullable = false)
    private TransactionTypeModel transaction_type;

    public UUID getId_movement() {
        return id_movement;
    }

    public void setId_movement(UUID id_movement) {
        this.id_movement = id_movement;
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

    public UserModel getId_user() {
        return id_user;
    }

    public void setId_user(UserModel id_user) {
        this.id_user = id_user;
    }

    public TransactionTypeModel getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(TransactionTypeModel transaction_type) {
        this.transaction_type = transaction_type;
    }
}
