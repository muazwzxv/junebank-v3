package com.muazwzxv.loanservice.controllers.offers.payload;

import lombok.Data;

@Data
public class UpdateOfferReqHttp {
    private String offerUUID;
    private String status;
}
