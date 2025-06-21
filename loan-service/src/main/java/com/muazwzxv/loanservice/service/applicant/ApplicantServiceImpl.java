package com.muazwzxv.loanservice.service.applicant;

import com.muazwzxv.loanservice.LoanServiceApplication;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicantServiceImpl implements IApplicantService {
    private static final Logger log = LoggerFactory.getLogger(LoanServiceApplication.class);
}
