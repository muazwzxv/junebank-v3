package com.muazwzxv.cardservice.mapper;

import com.muazwzxv.cardservice.dto.OrderDto;
import com.muazwzxv.cardservice.entities.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderDto toDto(OrderEntity order) {
        if (order == null) return null;

        return OrderDto.builder()
            .orderUUID(order.getOrderUUID())
            .customerUUID(order.getCustomerUUID())
            .designUUID(order.getDesignUUID())
            .status(order.getStatus())
            .createdAt(order.getCreatedAt())
            .createdBy(order.getCreatedBy())
            .updatedAt(order.getUpdatedAt())
            .updatedBy(order.getUpdatedBy())
            .build();
    }

    public OrderEntity toEntity(OrderDto dto) {
        if (dto == null) return null;

        OrderEntity order = OrderEntity.builder()
            .orderUUID(dto.getOrderUUID())
            .customerUUID(dto.getCustomerUUID())
            .designUUID(dto.getDesignUUID())
            .status(dto.getStatus())
            .build();

        order.setCreatedAt(dto.getCreatedAt());
        order.setCreatedBy(dto.getCreatedBy());
        order.setUpdatedAt(dto.getUpdatedAt());
        order.setUpdatedBy(dto.getUpdatedBy());

        return order;
    }

}
