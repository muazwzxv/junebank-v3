package com.muazwzxv.cardservice.services.transaction;

import com.muazwzxv.cardservice.dto.TransactionDto;
import com.muazwzxv.cardservice.repositories.TransactionRepository;
import com.muazwzxv.cardservice.services.transaction.payload.TransactionRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements ITransactionService {
    private TransactionRepository transactionRepository;

    @Override
    public TransactionDto charge(TransactionRequest req) {
        return null;
    }

    @Override
    public TransactionDto refund(TransactionRequest req) {
        return null;
    }
}
