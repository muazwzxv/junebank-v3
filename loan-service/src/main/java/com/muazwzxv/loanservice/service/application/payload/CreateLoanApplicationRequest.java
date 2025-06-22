package com.muazwzxv.loanservice.service.application.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateLoanApplicationRequest {
    private String applicantUUID;
    private String email;
}
