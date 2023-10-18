package com.wallet.tx_ms.repositories;

import com.wallet.tx_ms.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    @Query(value = "SELECT id_user, document_number FROM user WHERE document_number = :document", nativeQuery = true)
    Optional<UserModel> getUserId(@Param("document") Integer document);
}
