package com.muazwzxv.loanservice.services.application.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateLoanApplicationRequest {
    @NotEmpty(message = "applicationUUID cannot be empty")
    private String applicantUUID;

    @NotEmpty(message = "email cannot be empty")
    @Email(message = "email must be valid")
    private String email;
}
