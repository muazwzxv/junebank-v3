package com.muazwzxv.cardservice.services.order.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubmitOrderRequest {
    private String customerUUID;
    private String designUUID;
}
