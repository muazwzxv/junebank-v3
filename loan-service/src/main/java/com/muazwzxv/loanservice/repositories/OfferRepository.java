package com.muazwzxv.loanservice.repositories;

import com.muazwzxv.loanservice.entities.OfferEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {

    @Transactional
    Optional<OfferEntity> findByApplicationUUID(String applicationUUID);

    @Transactional
    Optional<OfferEntity> findByOfferUUID(String offerUUID);
}
