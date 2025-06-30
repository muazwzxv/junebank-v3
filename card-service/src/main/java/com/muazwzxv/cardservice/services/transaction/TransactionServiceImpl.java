package com.muazwzxv.cardservice.services.transaction;

import com.muazwzxv.cardservice.dto.CardDto;
import com.muazwzxv.cardservice.dto.TransactionDto;
import com.muazwzxv.cardservice.entities.CardEntity;
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

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements ITransactionService {
    private TransactionRepository transactionRepository;
    private CardRepository cardRepository;
    private CardMapper cardMapper;

    @Override
    public TransactionDto charge(TransactionRequest req) {
        // verify card exist and valid
        CardDto cardDto = isCardEligibleForTransaction(req.getCardUUID());

        return null;
    }

    @Override
    public TransactionDto refund(TransactionRequest req) {
        return null;
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
}
