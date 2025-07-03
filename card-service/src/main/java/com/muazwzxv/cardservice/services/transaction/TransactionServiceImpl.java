package com.muazwzxv.cardservice.services.transaction;

import com.muazwzxv.cardservice.dto.CardDto;
import com.muazwzxv.cardservice.dto.TransactionDto;
import com.muazwzxv.cardservice.entities.CardEntity;
import com.muazwzxv.cardservice.entities.TransactionEntity;
import com.muazwzxv.cardservice.enums.card.CardStatus;
import com.muazwzxv.cardservice.exceptions.ResourceNotFoundException;
import com.muazwzxv.cardservice.exceptions.cardsException.CardNotEligibleForTransaction;
import com.muazwzxv.cardservice.mapper.CardMapper;
import com.muazwzxv.cardservice.repositories.CardRepository;
import com.muazwzxv.cardservice.repositories.TransactionRepository;
import com.muazwzxv.cardservice.services.transaction.payload.TransactionRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements ITransactionService {
    private TransactionRepository transactionRepository;
    private CardRepository cardRepository;
    private CardMapper cardMapper;

    @Override
    public TransactionDto triggerTransaction(TransactionRequest req) {
        CardDto cardDto = isCardEligibleForTransaction(req.getCardUUID());
        return switch (req.getTransactionType()) {
            case "CHARGE" -> this.chargeCard(req, cardDto);
            case "REFUND" -> this.refundCard(req, cardDto);
            default ->
                // TODO: throw exception here
                null;
        };
    }

    public CardDto isCardEligibleForTransaction(String cardUUID) {
        CardEntity card = this.cardRepository.findByCardUUID(cardUUID).orElseThrow(
            () -> new ResourceNotFoundException("Card", "cardUUID", cardUUID)
        );

        Set<String> validStatuses = Set.of(CardStatus.CARD_ACTIVE.getValue());
        if (!validStatuses.contains(card.getStatus())) {
            throw new CardNotEligibleForTransaction(cardUUID, card.getStatus());
        }
        return this.cardMapper.toDto(card);
    }

    public TransactionDto chargeCard(TransactionRequest req, CardDto cardDto) {
        // TODO: handle charge transaction
        TransactionEntity transaction = TransactionEntity.builder()
            .transactionUUID(UUID.randomUUID().toString())
            .cardUUID(req.getCardUUID())
            .type("CHARGE")
            .status("PROCESSING")
            .build();

        return null;
    }

    public TransactionDto refundCard(TransactionRequest req, CardDto cardDto) {
        // TODO: verify ongoing charge transaction exist

        // create entry for refund
        TransactionEntity refundTransactionEntity = TransactionEntity.builder()
            .transactionUUID(req.getTransactionUUID())
            .cardUUID(req.getCardUUID())
            .type("REFUND")
            .status("PROCESSING")
            .build();

        this.transactionRepository.saveAndFlush(refundTransactionEntity);

        // TODO: create transaction mapper
        return null;
    }

}
