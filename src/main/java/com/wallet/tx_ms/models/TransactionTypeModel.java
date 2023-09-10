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
}
