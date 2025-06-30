package com.muazwzxv.cardservice.services.transaction;

import com.muazwzxv.cardservice.dto.TransactionDto;
import com.muazwzxv.cardservice.services.transaction.payload.TransactionRequest;

public interface ITransactionService {
    TransactionDto triggerTransaction(TransactionRequest req);
}
