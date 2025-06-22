package com.muazwzxv.loanservice.service.application.payload;

import lombok.Data;

@Data
public class CreateLoanApplicationRequest {
    private String applicantUUID;
    private String email;
}
