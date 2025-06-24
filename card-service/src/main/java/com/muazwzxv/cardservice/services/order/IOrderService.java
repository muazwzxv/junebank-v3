package com.muazwzxv.cardservice.services.order;

import com.muazwzxv.cardservice.dto.OrderDto;
import com.muazwzxv.cardservice.services.order.payload.SimulateOrderCompleteRequest;
import com.muazwzxv.cardservice.services.order.payload.SimulateOrderCompleteResponse;
import com.muazwzxv.cardservice.services.order.payload.SubmitOrderRequest;

public interface IOrderService {
    SubmitOrderRequest submitOrder(SubmitOrderRequest submitOrderRequest);
    OrderDto getOrderByCustomerUUID(String customerUUID);
    SimulateOrderCompleteResponse simulateOrderComplete(SimulateOrderCompleteRequest simulateOrderCompleteRequest);
}
