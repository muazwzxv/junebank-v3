package com.muazwzxv.loanservice.controllers.offers.Http;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SimulateOfferReqHttp {
    @NotEmpty(message = "uuid cannot be empty")
    private String applicationUUID;
}
