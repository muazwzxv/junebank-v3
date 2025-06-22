package com.muazwzxv.loanservice.service.application;

import com.muazwzxv.loanservice.dto.ApplicationDto;
import com.muazwzxv.loanservice.service.application.payload.CreateLoanApplicationRequest;
import com.muazwzxv.loanservice.service.application.payload.CreateLoanApplicationResponse;

import java.util.List;

public interface IApplicationService {
    CreateLoanApplicationResponse createLoanApplication(CreateLoanApplicationRequest request);
    ApplicationDto getApplication(String applicationUUID);
    List<ApplicationDto> getApplicationsByApplicantUUID(String applicantUUID);
}
