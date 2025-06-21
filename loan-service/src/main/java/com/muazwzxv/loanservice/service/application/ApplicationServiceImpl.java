package com.muazwzxv.loanservice.service.application;

import com.muazwzxv.loanservice.LoanServiceApplication;
import com.muazwzxv.loanservice.dto.ApplicationDto;
import com.muazwzxv.loanservice.repository.ApplicationRepository;
import com.muazwzxv.loanservice.service.application.payload.CreateLoanApplicationRequest;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements IApplicationService{
    private static final Logger log = LoggerFactory.getLogger(LoanServiceApplication.class);

    private ApplicationRepository applicationRepository;

    @Override
    public CreateLoanApplicationRequest createLoanApplication(CreateLoanApplicationRequest request) {
        return null;
    }

    @Override
    public ApplicationDto getApplication(String applicationUUID) {
        return null;
    }

    @Override
    public List<ApplicationDto> getApplicationsByApplicantUUID(String applicantUUID) {
        return List.of();
    }
}
