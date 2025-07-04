package com.muazwzxv.cardservice.exceptions.transactionsException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidTransactionTypeException extends RuntimeException {
    public InvalidTransactionTypeException(String cardUUID, String type) {
        super(String.format("Invalid transaction type: %s for card: %s", type, cardUUID));
    }
}
