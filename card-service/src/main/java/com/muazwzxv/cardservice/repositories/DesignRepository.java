package com.muazwzxv.cardservice.repositories;

import com.muazwzxv.cardservice.entities.DesignEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DesignRepository extends JpaRepository<DesignEntity, Long> {
    Optional<DesignEntity> findByDesignUUID(String designUUID);
}
