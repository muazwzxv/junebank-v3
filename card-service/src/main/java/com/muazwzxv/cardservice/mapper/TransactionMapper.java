package com.muazwzxv.cardservice.mapper;

import com.muazwzxv.cardservice.dto.TransactionDto;
import com.muazwzxv.cardservice.entities.TransactionEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    public TransactionDto toDto(TransactionEntity transaction) {
        if (transaction == null) return null;

        return TransactionDto.builder()
            .transactionUUID(transaction.getTransactionUUID())
            .cardUUID(transaction.getCardUUID())
            .type(transaction.getType())
            .status(transaction.getStatus())
            .createdAt(transaction.getCreatedAt())
            .createdBy(transaction.getCreatedBy())
            .updatedAt(transaction.getUpdatedAt())
            .updatedBy(transaction.getUpdatedBy())
            .build();
    }

    public TransactionEntity toEntity(TransactionDto dto) {
        if (dto == null) return null;

        TransactionEntity transaction = TransactionEntity.builder()
            .transactionUUID(dto.getTransactionUUID())
            .cardUUID(dto.getCardUUID())
            .type(dto.getType())
            .status(dto.getStatus())
            .build();

        transaction.setCreatedAt(dto.getCreatedAt());
        transaction.setCreatedBy(dto.getCreatedBy());
        transaction.setUpdatedAt(dto.getUpdatedAt());
        transaction.setUpdatedBy(dto.getUpdatedBy());

        return transaction;
    }
}
