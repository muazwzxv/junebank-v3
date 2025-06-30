package com.muazwzxv.cardservice.enums.card;

import lombok.Getter;

@Getter
public enum CardStatus {
    CARD_ACTIVE("ACTIVE"),
    CARD_ISSUED("ISSUED"),
    CARD_CANCELLED("CANCELLED");

    private final String value;

    CardStatus(String value) {
        this.value = value;
    }
}
