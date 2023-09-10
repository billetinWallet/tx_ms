package com.wallet.tx_ms.dtos;

import jakarta.validation.constraints.NotNull;

public record TransactionTypeRecordDto(@NotNull int id_transaction_type, @NotNull String transaction_type_name) {
}
