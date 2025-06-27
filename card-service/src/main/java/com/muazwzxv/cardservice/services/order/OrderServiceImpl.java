package com.muazwzxv.cardservice.services.order;

import com.muazwzxv.cardservice.dto.OrderDto;
import com.muazwzxv.cardservice.entities.DesignEntity;
import com.muazwzxv.cardservice.entities.OrderEntity;
import com.muazwzxv.cardservice.exceptions.ResourceNotFoundException;
import com.muazwzxv.cardservice.exceptions.ordersException.OrderInProgressException;
import com.muazwzxv.cardservice.mapper.OrderMapper;
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
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class OrderServiceImpl implements IOrderService{
    private OrderRepository orderRepository;
    private DesignRepository designRepository;

    private OrderMapper orderMapper;

    @Override
    public SubmitOrderResponse submitOrder(SubmitOrderRequest req) {
        // TODO: verify customer exist
        // - API call to another service

        // verify design exist
        DesignEntity designEntity = this.designRepository.findByDesignUUID(req.getDesignUUID()).orElseThrow(
            () -> new ResourceNotFoundException("Design", "designUUID", req.getDesignUUID())
        );

        // check if customer has existing order in progress
        List<OrderEntity> orderList = this.orderRepository.findAllByCustomerUUID(req.getCustomerUUID());
        if (!orderList.isEmpty()) {
            log.info("customer has previous orders, customerUUID: {}", req.getCustomerUUID());
            for (OrderEntity orderEntity : orderList) {
                if (!Objects.equals(orderEntity.getStatus(), "COMPLETED")) {
                    throw new OrderInProgressException(req.getCustomerUUID());
                }
            }
        }

        OrderEntity orderEntity = OrderEntity.builder()
            .orderUUID(UUID.randomUUID().toString())
            .customerUUID(req.getCustomerUUID())
            .designUUID(designEntity.getDesignUUID())
            .status("SUBMITTED")
            .build();
        this.orderRepository.save(orderEntity);

        return SubmitOrderResponse.builder()
            .orderUUID(orderEntity.getOrderUUID())
            .build();
    }

    @Override
    public OrderDto getOrderByOrderUUID(String orderUUID) {
        OrderEntity orderEntity = this.orderRepository.findByOrderUUID(orderUUID).orElseThrow(
            () -> new ResourceNotFoundException("Order", "orderUUID", orderUUID)
        );
        return this.orderMapper.toDto(orderEntity);
    }

    @Override
    public SimulateOrderCompleteResponse simulateOrderComplete(
        SimulateOrderCompleteRequest simulateOrderCompleteRequest
    ) {
        return null;
    }
}
