package com.wallet.tx_ms.dtos;

import com.wallet.tx_ms.models.UserModel;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record InternalTransactionRecordDto(@NotNull UUID id_internal_transaction, @NotNull UserModel source_account, @NotNull UserModel target_account, @NotNull float amount, @NotNull
                                           LocalDateTime datetime, @NotNull char state) {
}
