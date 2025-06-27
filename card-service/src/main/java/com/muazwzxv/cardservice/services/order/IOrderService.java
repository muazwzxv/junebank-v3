package com.muazwzxv.cardservice.services.order;

import com.muazwzxv.cardservice.dto.OrderDto;
import com.muazwzxv.cardservice.services.order.payload.SimulateOrderCompleteRequest;
import com.muazwzxv.cardservice.services.order.payload.SimulateOrderCompleteResponse;
import com.muazwzxv.cardservice.services.order.payload.SubmitOrderRequest;
import com.muazwzxv.cardservice.services.order.payload.SubmitOrderResponse;

public interface IOrderService {
    SubmitOrderResponse submitOrder(SubmitOrderRequest submitOrderRequest);
    OrderDto getOrderByOrderUUID(String orderUUID);
    SimulateOrderCompleteResponse simulateOrderComplete(SimulateOrderCompleteRequest simulateOrderCompleteRequest);
}
