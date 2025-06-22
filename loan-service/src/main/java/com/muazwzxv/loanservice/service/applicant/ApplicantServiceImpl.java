package com.muazwzxv.loanservice.service.applicant;

import com.muazwzxv.loanservice.LoanServiceApplication;
import com.muazwzxv.loanservice.dto.ApplicantDto;
import com.muazwzxv.loanservice.entities.ApplicantEntity;
import com.muazwzxv.loanservice.exception.ResourceNotFoundException;
import com.muazwzxv.loanservice.mapper.ApplicantMapper;
import com.muazwzxv.loanservice.repository.ApplicantRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ApplicantServiceImpl implements IApplicantService {
    private static final Logger log = LoggerFactory.getLogger(LoanServiceApplication.class);
    private ApplicantRepository applicantRepository;
    private ApplicantMapper applicantMapper;

    @Override
    public ApplicantDto getApplicantByUUID(String uuid) {
        ApplicantEntity applicantEntity = this.applicantRepository.findByApplicantUUID(uuid).orElseThrow(
                () -> new ResourceNotFoundException("Applicant", "applicantUUID", uuid)
        );

        return applicantMapper.toDto(applicantEntity);
    }
}
