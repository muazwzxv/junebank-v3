package com.muazwzxv.loanservice.repository;

import com.muazwzxv.loanservice.entities.ApplicantEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicantRepository {

    @Transactional
    @Modifying
    Optional<ApplicantEntity> findByApplicantUUID(String applicantUUID);
}
