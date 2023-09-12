package com.wallet.tx_ms.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Immutable
@Table(name = "MOVEMENT")
public class MovementModel {
    @Id
    private UUID id_movement;

    @Column(nullable = false)
    private float amount;

    @Column(nullable = false)
    private LocalDateTime datetime;

    public UUID getId_movement() {
        return id_movement;
    }

    public float getAmount() {
        return amount;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }
}
