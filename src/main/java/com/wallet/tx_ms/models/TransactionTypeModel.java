package com.wallet.tx_ms.models;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "TRANSACTION_TYPE")
public class TransactionTypeModel {
    @Id
    @GeneratedValue
    private int id_transaction_type;

    @Column(nullable = false)
    private String transaction_type_name;

    public int getId_transaction_type() {
        return id_transaction_type;
    }

    public void setId_transaction_type(int id_transaction_type) {
        this.id_transaction_type = id_transaction_type;
    }

    public String getTransaction_type_name() {
        return transaction_type_name;
    }

    public void setTransaction_type_name(String transaction_type_name) {
        this.transaction_type_name = transaction_type_name;
    }

    public TransactionTypeModel() {}

    public TransactionTypeModel(int id_transaction_type) {
        this.id_transaction_type = id_transaction_type;
    }
}
