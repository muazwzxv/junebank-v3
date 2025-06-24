package com.muazwzxv.loanservice.controllers.offers.Http;

import com.muazwzxv.loanservice.dto.OfferDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateOfferRespHttp {
    private OfferDto offer;
}

