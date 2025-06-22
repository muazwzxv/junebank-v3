package com.muazwzxv.loanservice.repository;

import com.muazwzxv.loanservice.entities.ApplicationEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {

    @Transactional
    @Modifying
    Optional<ApplicationEntity> findByApplicationUUID(String applicationUUID);

    @Transactional
    @Modifying
    Optional<ApplicationEntity> findByApplicantUUID(String applicantUUID);
}
