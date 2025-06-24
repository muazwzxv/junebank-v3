package com.muazwzxv.loanservice.exceptions.offerException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value  = HttpStatus.BAD_REQUEST)
public class OfferPendingException extends RuntimeException{
    public OfferPendingException(String offerUUID, String applicationUUID) {
        super(String.format("Application: %s has an existing offer: %s", applicationUUID, offerUUID));
    }
}
