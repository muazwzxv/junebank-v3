package com.muazwzxv.loanservice.exceptions.applicationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value  = HttpStatus.BAD_REQUEST)
public class ApplicationInProgressException extends RuntimeException {
    public ApplicationInProgressException(String applicantUUID, String applicationUUID, String status) {
        super(String.format("Applicant: %s has an in progress Application: %s with status: %s", applicantUUID, applicationUUID, status));
    }
}
