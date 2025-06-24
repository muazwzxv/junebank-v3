package com.muazwzxv.loanservice.controllers.applications.Http;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateLoanApplicationRespHttp {
    private String applicationUUID;
    private String status;
    private String statusReason;
    private String createdAt;
}
