package com.muazwzxv.loanservice.service.application;

import com.muazwzxv.loanservice.LoanServiceApplication;
import com.muazwzxv.loanservice.dto.ApplicationDto;
import com.muazwzxv.loanservice.entities.ApplicantEntity;
import com.muazwzxv.loanservice.entities.ApplicationEntity;
import com.muazwzxv.loanservice.exception.applicationException.ApplicationInProgressException;
import com.muazwzxv.loanservice.repository.ApplicantRepository;
import com.muazwzxv.loanservice.repository.ApplicationRepository;
import com.muazwzxv.loanservice.service.application.payload.CreateLoanApplicationRequest;
import com.muazwzxv.loanservice.service.application.payload.CreateLoanApplicationResponse;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements IApplicationService{
    private static final Logger log = LoggerFactory.getLogger(LoanServiceApplication.class);

    private ApplicationRepository applicationRepository;
    private ApplicantRepository applicantRepository;

    @Override
    public CreateLoanApplicationResponse createLoanApplication(CreateLoanApplicationRequest request) {
        // TODO: verify if applicant info is correct, make API call to account service

        ApplicantEntity applicantEntity;
        Optional<ApplicantEntity> applicantEntityOptional = this.applicantRepository.findByApplicantUUID(request.getApplicantUUID());
        if (applicantEntityOptional.isPresent()) {
            applicantEntity = applicantEntityOptional.get();
        } else {
            ApplicantEntity newApplicantEntity = ApplicantEntity.builder()
                .applicantUUID(request.getApplicantUUID())
                .email(request.getEmail())
                .status("ACTIVE")
                .build();
            this.applicantRepository.save(newApplicantEntity); // global DB handler will resolve the error if there's issue
            applicantEntity = newApplicantEntity;
            log.info("creating new applicant entry for Applicant: {}", request.getApplicantUUID());
        }

        // check if customer has existing ongoing application
        List<ApplicationEntity> applicationEntityList = this.applicationRepository.findByApplicantUUID(applicantEntity.getApplicantUUID());
        if (!applicationEntityList.isEmpty()) {
            for (ApplicationEntity applicationEntity : applicationEntityList) {
                Set<String> validStatuses = Set.of("PROCESSING");
                if (validStatuses.contains(applicationEntity.getStatus())) {
                    log.warn("application already in progress for applicant: {}, application: {}, status: {}",
                        applicationEntity.getApplicantUUID(),
                        applicationEntity.getApplicationUUID(),
                        applicationEntity.getStatus());

                    throw new ApplicationInProgressException(applicationEntity.getApplicantUUID(), applicationEntity.getApplicationUUID(), applicationEntity.getStatus());
                }
            }
        }

        // create application
        ApplicationEntity applicationEntity = ApplicationEntity.builder()
            .applicantUUID(applicantEntity.getApplicantUUID())
            .applicationUUID(UUID.randomUUID().toString())
            .status("PROCESSING")
            .statusReason("APPLICATION_SUBMIT")
            .build();
        this.applicationRepository.save(applicationEntity);

        return CreateLoanApplicationResponse.builder()
            .applicationUUID(applicationEntity.getApplicationUUID())
            .status(applicationEntity.getStatus())
            .statusReason(applicationEntity.getStatusReason())
            .createdAt(applicationEntity.getCreatedAt())
            .build();
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
