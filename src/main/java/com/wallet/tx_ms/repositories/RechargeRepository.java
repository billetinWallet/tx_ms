package com.wallet.tx_ms.repositories;

import com.wallet.tx_ms.models.RechargeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RechargeRepository extends JpaRepository<RechargeModel, UUID> {
}
