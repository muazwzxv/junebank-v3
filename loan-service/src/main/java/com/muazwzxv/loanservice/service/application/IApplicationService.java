package com.muazwzxv.loanservice.service.application;

import com.muazwzxv.loanservice.dto.ApplicationDto;
import com.muazwzxv.loanservice.service.application.payload.CreateLoanApplicationRequest;

import java.util.List;

public interface IApplicationService {
    CreateLoanApplicationRequest createLoanApplication(CreateLoanApplicationRequest request);
    ApplicationDto getApplication(String applicationUUID);
    List<ApplicationDto> getApplicationsByApplicantUUID(String applicantUUID);
}
