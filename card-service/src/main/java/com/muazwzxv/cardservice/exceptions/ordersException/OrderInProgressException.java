package com.muazwzxv.cardservice.exceptions.ordersException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class OrderInProgressException extends RuntimeException {
    public OrderInProgressException(String customerUUID) {
        super(String.format("Customer: %s has order in progress", customerUUID));
    }
}
