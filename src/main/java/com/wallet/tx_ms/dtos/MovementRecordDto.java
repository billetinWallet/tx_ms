package com.wallet.tx_ms.dtos;

import com.wallet.tx_ms.models.TransactionTypeModel;
import com.wallet.tx_ms.models.UserModel;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record MovementRecordDto(@NotNull UUID id_movement, @NotNull float amount, @NotNull LocalDateTime datetime, @NotNull
                                UserModel id_user, @NotNull TransactionTypeModel transaction_type) {
}
