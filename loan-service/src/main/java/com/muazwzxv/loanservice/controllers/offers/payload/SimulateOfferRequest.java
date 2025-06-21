package com.muazwzxv.loanservice.controllers.offers.payload;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SimulateOfferRequest {
    @NotEmpty(message = "uuid cannot be empty")
    private String applicationUUID;
}
