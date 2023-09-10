package com.wallet.tx_ms.models;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "BALANCE")
public class BalanceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_balance;

    @Column(nullable = false)
    private float balance;

    @Column(nullable = false)
    private LocalDateTime update_time = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private UserModel id_user;

    public int getId_balance() {
        return id_balance;
    }

    public void setId_balance(int id_balance) {
        this.id_balance = id_balance;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = LocalDateTime.now();
    }

    public UserModel getId_user() {
        return id_user;
    }

    public void setId_user(UserModel id_user) {
        this.id_user = id_user;
    }
}
