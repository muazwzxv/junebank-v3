package com.muazwzxv.cardservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "card_order")
public class OrderEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "id")
    private Long id;

    @Column(name = "order_uuid")
    private String orderUUID;

    @Column(name = "customer_uuid")
    private String customerUUID;

    @Column(name = "design_uuid")
    private String designUUID;

    @Column(name = "status")
    private String status;
}
