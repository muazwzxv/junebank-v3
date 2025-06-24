package com.muazwzxv.loanservice.services.offer.payload;

import com.muazwzxv.loanservice.dto.OfferDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateOfferResp {
    private OfferDto offer;
}
