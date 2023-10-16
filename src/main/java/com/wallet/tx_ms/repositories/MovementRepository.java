package com.wallet.tx_ms.repositories;

import com.wallet.tx_ms.models.BalanceModel;
import com.wallet.tx_ms.models.MovementModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovementRepository extends JpaRepository<MovementModel, UUID> {
    @Query(value = "SELECT * FROM MOVEMENT WHERE id_user = :id_user ORDER BY datetime DESC", nativeQuery = true)
    Optional<List<MovementModel>> findByUserId(@Param("id_user") Integer id_user);
}
