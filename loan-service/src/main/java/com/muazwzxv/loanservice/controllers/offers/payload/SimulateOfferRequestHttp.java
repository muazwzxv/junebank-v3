package com.muazwzxv.loanservice.controllers.offers.payload;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SimulateOfferRequestHttp {
    @NotEmpty(message = "uuid cannot be empty")
    private String applicationUUID;
}
