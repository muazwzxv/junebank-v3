package com.muazwzxv.loanservice.controllers.applications.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateLoanApplicationResponse {
    private String applicationUUID;
    private String status;
    private String statusReason;
    private String createdAt;
}
