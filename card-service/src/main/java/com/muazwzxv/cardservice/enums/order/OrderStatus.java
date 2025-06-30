package com.muazwzxv.cardservice.enums.order;

import lombok.Getter;

@Getter
public enum OrderStatus {
    ORDER_SUBMITTED("SUBMITTED"),
    ORDER_COMPLETED("COMPLETED");

    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }
}
