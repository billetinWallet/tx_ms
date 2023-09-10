package com.wallet.tx_ms.models;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "INTERNAL_TRANSACTION")
public class InternalTransactionModel {

    @Id
    @GeneratedValue
    private UUID id_internal_transaction;

    @ManyToOne
    @JoinColumn(name = "source_account", nullable = false)
    private UserModel source_account;

    @ManyToOne
    @JoinColumn(name = "target_account", nullable = false)
    private UserModel target_account;

    @Column(nullable = false)
    private float amount;

    @Column(nullable = false)
    private LocalDateTime datetime = LocalDateTime.now();

    @Column(nullable = false)
    private char state;

    public UUID getId_internal_transaction() {
        return id_internal_transaction;
    }

    public void setId_internal_transaction(UUID id_internal_transaction) {
        this.id_internal_transaction = id_internal_transaction;
    }

    public UserModel getSource_account() {
        return source_account;
    }

    public void setSource_account(UserModel source_account) {
        this.source_account = source_account;
    }

    public UserModel getTarget_account() {
        return target_account;
    }

    public void setTarget_account(UserModel target_account) {
        this.target_account = target_account;
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
}
