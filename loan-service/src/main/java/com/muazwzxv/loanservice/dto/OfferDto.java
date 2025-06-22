package com.muazwzxv.loanservice.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class OfferDto {
    private String applicationUUID;
    private String offeredLimit;
    private String offeredInterest;
    private String status;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
