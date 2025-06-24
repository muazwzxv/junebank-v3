package com.muazwzxv.cardservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transaction")
public class TransactionEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "id")
    private Long id;

    @Column(name = "transaction_uuid")
    private String transactionUUID;

    @Column(name = "card_uuid")
    private String cardUUID;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;
}
