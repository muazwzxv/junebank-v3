package com.muazwzxv.loanservice.repositories;

import com.muazwzxv.loanservice.entities.ApplicantEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicantRepository extends JpaRepository<ApplicantEntity, Long> {

    @Transactional
    Optional<ApplicantEntity> findByApplicantUUID(String applicantUUID);
}
