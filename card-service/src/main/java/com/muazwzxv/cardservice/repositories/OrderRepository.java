package com.muazwzxv.cardservice.repositories;

import com.muazwzxv.cardservice.entities.OrderEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Transactional
    Optional<OrderEntity> findByCustomerUUID(String customerUUID);
}
