package com.muazwzxv.cardservice.repositories;

import com.muazwzxv.cardservice.entities.CardEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long> {
    @Transactional
    Optional<CardEntity> findByCardUUID(String cardUUID);

    @Transactional
    List<CardEntity> findAllByCustomerUUID(String customerUUID);
}
