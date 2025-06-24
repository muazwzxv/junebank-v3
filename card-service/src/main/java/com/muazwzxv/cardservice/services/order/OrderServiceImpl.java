package com.muazwzxv.cardservice.services.order;

import com.muazwzxv.cardservice.dto.OrderDto;
import com.muazwzxv.cardservice.repositories.OrderRepository;
import com.muazwzxv.cardservice.services.order.payload.SimulateOrderCompleteRequest;
import com.muazwzxv.cardservice.services.order.payload.SimulateOrderCompleteResponse;
import com.muazwzxv.cardservice.services.order.payload.SubmitOrderRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements IOrderService{
    private OrderRepository orderRepository;

    @Override
    public SubmitOrderRequest submitOrder(SubmitOrderRequest submitOrderRequest) {
        return null;
    }

    @Override
    public OrderDto getOrderByCustomerUUID(String customerUUID) {
        return null;
    }

    @Override
    public SimulateOrderCompleteResponse simulateOrderComplete(
        SimulateOrderCompleteRequest simulateOrderCompleteRequest
    ) {
        return null;
    }
}
