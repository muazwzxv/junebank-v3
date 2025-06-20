package com.muazwzxv.loanservice.repository;

import com.muazwzxv.loanservice.entities.ApplicationEntity;
import com.muazwzxv.loanservice.entities.OfferEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferRepository {

    @Transactional
    @Modifying
    Optional<OfferEntity> findByApplicationUUID(String applicationUUID);
}
