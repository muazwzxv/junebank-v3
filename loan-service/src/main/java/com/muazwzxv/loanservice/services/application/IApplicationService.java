package com.muazwzxv.loanservice.services.application;

import com.muazwzxv.loanservice.dto.ApplicationDto;
import com.muazwzxv.loanservice.services.application.payload.CreateLoanApplicationRequest;
import com.muazwzxv.loanservice.services.application.payload.CreateLoanApplicationResponse;

import java.util.List;

public interface IApplicationService {
    CreateLoanApplicationResponse createLoanApplication(CreateLoanApplicationRequest request);
    ApplicationDto getApplication(String applicationUUID);
    List<ApplicationDto> getApplicationsByApplicantUUID(String applicantUUID);
}
