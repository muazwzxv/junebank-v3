package com.muazwzxv.loanservice.services.application.payload;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CreateLoanApplicationResponse {
    private String applicationUUID;
    private String status;
    private String statusReason;
    private LocalDateTime createdAt;
}
