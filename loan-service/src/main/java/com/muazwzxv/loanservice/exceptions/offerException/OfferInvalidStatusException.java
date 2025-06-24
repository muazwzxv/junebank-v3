package com.muazwzxv.loanservice.exceptions.offerException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class OfferInvalidStatusException extends RuntimeException{
    public OfferInvalidStatusException(String offerUUID) {
        super(String.format("Offer: %s is in an invalid status", offerUUID));
    }
}
