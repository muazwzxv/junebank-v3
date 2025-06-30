package com.muazwzxv.loanservice.enums.application;

import lombok.Getter;

@Getter
public enum ApplicationStatus {
    PENDING_ACCEPTANCE("PENDING_ACCEPTANCE"),
    ACCEPTED("ACCEPTED"),
    REJECTED("REJECTED"),
    CANCELLED("PROCESSING");

    private final String value;

    ApplicationStatus(String value) {
        this.value = value;
    }
}

