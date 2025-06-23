package com.muazwzxv.loanservice.enums.application;

public enum ApplicationStatus {
    PENDING_ACCEPTANCE("PENDING_ACCEPTANCE"),
    ACCEPTED("ACCEPTED"),
    REJECTED("REJECTED"),
    CANCELLED("PROCESSING");

    private final String value;

    ApplicationStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

