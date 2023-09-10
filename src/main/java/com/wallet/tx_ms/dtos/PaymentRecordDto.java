package com.wallet.tx_ms.dtos;

import com.wallet.tx_ms.models.UserModel;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record PaymentRecordDto(@NotNull UUID id_payment, @NotNull float amount, @NotNull LocalDateTime datetime, @NotNull char state, @NotNull
                               UserModel id_user) {
}
