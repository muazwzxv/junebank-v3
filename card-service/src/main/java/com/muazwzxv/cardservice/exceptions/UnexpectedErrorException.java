package com.muazwzxv.cardservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class UnexpectedErrorException extends RuntimeException {
    public UnexpectedErrorException(String errorString, Throwable cause) {
        super(errorString, cause);
    }
}
