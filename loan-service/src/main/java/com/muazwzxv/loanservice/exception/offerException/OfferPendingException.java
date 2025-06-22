package com.muazwzxv.loanservice.exception.offerException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value  = HttpStatus.BAD_REQUEST)
public class OfferPendingException extends RuntimeException{
    public OfferPendingException(String offerUUID, String applicationUUID, String status) {
        super(String.format("Application: %s has an existing offer: %s with status: %s", applicationUUID, offerUUID, status));
    }
}
