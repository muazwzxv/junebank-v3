package com.muazwzxv.loanservice.controllers.offers.Http;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UpdateOfferReqHttp {
    @NotEmpty(message = "offerUUID cannot be empty")
    private String offerUUID;

    @NotEmpty(message = "status cannot be empty")
    private String status;
}
