package com.wallet.tx_ms.models;


import jakarta.persistence.*;

@Entity
@Table(name = "USER")
public class UserModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;

    @Column(nullable = false)
    private int document_number;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getDocument_number() {
        return document_number;
    }

    public void setDocument_number(int document_number) {
        this.document_number = document_number;
    }

    public UserModel() {}

    public UserModel(int id_user) {
        this.id_user = id_user;
    }
}
