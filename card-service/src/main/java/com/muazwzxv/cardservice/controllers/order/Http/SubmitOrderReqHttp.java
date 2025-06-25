package com.muazwzxv.cardservice.controllers.order.Http;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SubmitOrderReqHttp {
    @NotEmpty(message = "customer cannot be empty or null")
    private String customerUUID;

    @NotEmpty(message = "design cannot be empty or null")
    private String designUUID;
}
