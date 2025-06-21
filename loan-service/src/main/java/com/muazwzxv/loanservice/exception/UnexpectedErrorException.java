package com.muazwzxv.loanservice.exception;

public class UnexpectedErrorException extends RuntimeException {
    public UnexpectedErrorException(String errorString, Throwable cause) {
        super(errorString, cause);
    }
}
