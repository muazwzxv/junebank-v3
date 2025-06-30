package com.muazwzxv.cardservice.controllers.card.Http;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DisableCardReqHttp {
    @NotEmpty(message = "uuid cannot be empty")
    private String cardUUID;
}
