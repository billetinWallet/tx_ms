package com.wallet.tx_ms.dtos;

import jakarta.validation.constraints.NotNull;

public record UserRecordDto(@NotNull int id_user, @NotNull int document_number) {
}
