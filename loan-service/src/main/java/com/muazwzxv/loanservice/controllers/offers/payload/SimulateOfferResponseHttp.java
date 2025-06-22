package com.muazwzxv.loanservice.controllers.offers.payload;

import com.muazwzxv.loanservice.dto.OfferDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimulateOfferResponseHttp {
    private OfferDto offer;
}
