package com.muazwzxv.loanservice.service.offer.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateOfferReq {
    private String offerUUID;
    private String status;
}
