package com.wallet.tx_ms.dtos;

import com.wallet.tx_ms.models.UserModel;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record BalanceRecordDto(@NotNull int id_balance, @NotNull float balance, @NotNull LocalDateTime update_time, @NotNull
                               UserModel user) {
}
