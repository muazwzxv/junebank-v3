package com.muazwzxv.cardservice.enums.design;

import lombok.Getter;

@Getter
public enum DesignStatus {
    DESIGN_ACTIVE("ACTIVE");

    private final String value;

    DesignStatus(String value) {
        this.value = value;
    }
}
