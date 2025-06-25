package com.muazwzxv.cardservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadInputException extends RuntimeException{
    public BadInputException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("bad input of %s with value %s", fieldName, fieldValue));
    }
}
