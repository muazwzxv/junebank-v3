package com.muazwzxv.cardservice.controllers.transaction.Http;

import com.muazwzxv.cardservice.dto.TransactionDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionRespHttp {
    private String cardUUID;
    private TransactionDto transaction;
}
