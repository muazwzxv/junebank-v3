package com.muazwzxv.cardservice.controllers.transaction.Http;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionReqHttp {
    private String cardUUID;
    private String transactionType;
    private String amount;
}
