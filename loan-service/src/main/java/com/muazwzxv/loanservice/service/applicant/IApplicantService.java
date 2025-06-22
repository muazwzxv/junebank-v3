package com.muazwzxv.loanservice.service.applicant;

import com.muazwzxv.loanservice.dto.ApplicantDto;

public interface IApplicantService {
   ApplicantDto getApplicantByUUID(String uuid);
}
