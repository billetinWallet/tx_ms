package com.wallet.tx_ms.repositories;

import com.wallet.tx_ms.models.BalanceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<BalanceModel, Integer> {
}
