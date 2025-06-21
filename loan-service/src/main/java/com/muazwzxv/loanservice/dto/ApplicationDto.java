package com.muazwzxv.loanservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApplicationDto {
    private String applicantUUID;
    private String applicationUUID;
    private String status;
    private String statusReason;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}