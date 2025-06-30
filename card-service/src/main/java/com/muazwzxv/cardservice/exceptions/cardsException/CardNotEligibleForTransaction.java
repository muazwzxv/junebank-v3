package com.muazwzxv.cardservice.exceptions.cardsException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CardNotEligibleForTransaction extends RuntimeException {
    public CardNotEligibleForTransaction(String cardUUID, String status) {
        super(String.format("Card: %s is not eligible for transaction, status: %s", cardUUID, status));
    }
}
