package com.muazwzxv.cardservice.exceptions.ordersException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class OrderInvalidStateException extends RuntimeException {
    public OrderInvalidStateException(String orderUUID, String status) {
        super(String.format("Order: %s is in an invalid state: %s", orderUUID, status));
    }
}
