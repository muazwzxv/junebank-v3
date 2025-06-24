package com.muazwzxv.loanservice.repositories;

import com.muazwzxv.loanservice.entities.ApplicationEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {

    @Transactional
    Optional<ApplicationEntity> findByApplicationUUID(String applicationUUID);

    @Transactional
    List<ApplicationEntity> findByApplicantUUID(String applicantUUID);
}
