package com.muazwzxv.cardservice.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class OrderDto {
    private String orderUUID;
    private String customerUUID;
    private String designUUID;
    private String status;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
