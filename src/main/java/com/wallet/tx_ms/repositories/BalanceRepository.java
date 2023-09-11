package com.wallet.tx_ms.repositories;

import com.wallet.tx_ms.models.BalanceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BalanceRepository extends JpaRepository<BalanceModel, Integer> {

    @Query(value = "SELECT * FROM BALANCE WHERE id_user = :id_user ORDER BY update_time DESC LIMIT 1", nativeQuery = true)
    Optional<BalanceModel> findLastByUserId(@Param("id_user") Integer id_user);
}
