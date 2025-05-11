package com.muazwzxv.accounts.exception.accountException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NoAccountForUpdateException extends RuntimeException {
    public NoAccountForUpdateException(String customerPhone) {
        super(String.format("customer %s does not have an account to be updated", customerPhone));
    }
}
