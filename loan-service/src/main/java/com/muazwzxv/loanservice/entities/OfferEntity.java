package com.muazwzxv.loanservice.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "offer")
public class OfferEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "id")
    private Long id;

    @Column(name = "application_uuid")
    private String applicationUUID;

    @Column(name = "offered_limit")
    private String offeredLimit;

    @Column(name = "offered_interest")
    private String offeredInterest;

    @Column(name = "status")
    private String status;
}
