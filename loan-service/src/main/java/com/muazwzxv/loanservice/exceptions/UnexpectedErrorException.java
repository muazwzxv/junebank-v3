package com.muazwzxv.loanservice.exceptions;

public class UnexpectedErrorException extends RuntimeException {
    public UnexpectedErrorException(String errorString, Throwable cause) {
        super(errorString, cause);
    }
}
