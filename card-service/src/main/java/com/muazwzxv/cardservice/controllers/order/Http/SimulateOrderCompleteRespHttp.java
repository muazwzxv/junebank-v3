package com.muazwzxv.cardservice.controllers.order.Http;

import com.muazwzxv.cardservice.dto.OrderDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimulateOrderCompleteRespHttp {
    private String cardUUID;
    private String status;
    private OrderDto order;
}
