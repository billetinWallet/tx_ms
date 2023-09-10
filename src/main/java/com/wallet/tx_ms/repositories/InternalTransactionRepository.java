package com.wallet.tx_ms.repositories;

import com.wallet.tx_ms.models.InternalTransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InternalTransactionRepository extends JpaRepository<InternalTransactionModel, UUID> {
}
