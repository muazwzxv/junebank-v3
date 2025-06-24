package com.muazwzxv.loanservice.services.applicant;

import com.muazwzxv.loanservice.dto.ApplicantDto;

public interface IApplicantService {
   ApplicantDto getApplicantByUUID(String uuid);
}
