package com.muazwzxv.cardservice.services.transaction.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionRequest {
    private String cardUUID;
    private String transactionType;
    private String amount;
}
