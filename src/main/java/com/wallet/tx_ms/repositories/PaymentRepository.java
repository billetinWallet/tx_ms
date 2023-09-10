package com.wallet.tx_ms.repositories;

import com.wallet.tx_ms.models.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<PaymentModel, UUID> {
}
