package com.wallet.tx_ms.repositories;

import com.wallet.tx_ms.models.TransactionTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionTypeRepository extends JpaRepository<TransactionTypeModel, Integer> {
}
