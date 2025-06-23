package com.muazwzxv.loanservice.enums.offer;

import lombok.Getter;

@Getter
public enum OfferStatus {
    PENDING_ACCEPTANCE("PENDING_ACCEPTANCE"),
    OFFER_ACCEPTED("OFFER_ACCEPTED"),
    OFFER_DECLINED("OFFER_DECLINED"),
    OFFER_EXPIRED("OFFER_EXPIRED");

    private final String value;

    OfferStatus(String value) {
        this.value = value;
    }

}
