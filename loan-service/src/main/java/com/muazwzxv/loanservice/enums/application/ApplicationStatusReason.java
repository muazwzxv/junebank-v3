package com.muazwzxv.loanservice.enums.application;

import lombok.Getter;

@Getter
public enum ApplicationStatusReason {
    OFFER_CREATED("OFFER_CREATED"),
    APPROVED("APPROVED"),
    REJECTED("REJECTED"),
    PROCESSING("PROCESSING");

    private final String value;

    ApplicationStatusReason(String value) {
        this.value = value;
    }
}
