package com.wallet.tx_ms.repositories;

import com.wallet.tx_ms.models.MovementModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovementRepository extends JpaRepository<MovementModel, UUID> {
}
