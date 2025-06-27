package com.muazwzxv.cardservice.services.order;

import com.muazwzxv.cardservice.dto.OrderDto;
import com.muazwzxv.cardservice.entities.DesignEntity;
import com.muazwzxv.cardservice.entities.OrderEntity;
import com.muazwzxv.cardservice.exceptions.ResourceNotFoundException;
import com.muazwzxv.cardservice.repositories.DesignRepository;
import com.muazwzxv.cardservice.repositories.OrderRepository;
import com.muazwzxv.cardservice.services.order.payload.SimulateOrderCompleteRequest;
import com.muazwzxv.cardservice.services.order.payload.SimulateOrderCompleteResponse;
import com.muazwzxv.cardservice.services.order.payload.SubmitOrderRequest;
import com.muazwzxv.cardservice.services.order.payload.SubmitOrderResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
public class OrderServiceImpl implements IOrderService{
    private OrderRepository orderRepository;
    private DesignRepository designRepository;

    @Override
    public SubmitOrderResponse submitOrder(SubmitOrderRequest req) {
        // TODO: verify customer exist

        // verify design exist
        DesignEntity designEntity = this.designRepository.findByDesignUUID(req.getDesignUUID()).orElseThrow(
            () -> new ResourceNotFoundException("Design", "designUUID", req.getDesignUUID())
        );

        // check if customer has existing order in progress
        List<OrderEntity> orderList = this.orderRepository.findAllByCustomerUUID(req.getCustomerUUID());
        if (!orderList.isEmpty()) {
            log.info("customer has previous orders, customerUUID: {}", req.getCustomerUUID());
            for (OrderEntity orderEntity : orderList) {
                if (Objects.equals(orderEntity.getStatus(), "COMPLETED")) {

                }
            }
        }


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
