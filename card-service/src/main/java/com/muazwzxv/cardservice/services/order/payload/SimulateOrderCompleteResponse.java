package com.muazwzxv.cardservice.services.order.payload;

import com.muazwzxv.cardservice.dto.OrderDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimulateOrderCompleteResponse {
    public String cardUUID;
    public String status;
    public OrderDto order;
}
