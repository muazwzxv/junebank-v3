package com.muazwzxv.loanservice.controllers.applications.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class CreateLoanApplicationRequest {
    @NotEmpty(message = "applicant_uuid cannot be empty")
    private String applicantUUID;

    @NotEmpty(message = "email cannot be empty")
    @Email(message = " needs to be valid")
    private String email;
}
