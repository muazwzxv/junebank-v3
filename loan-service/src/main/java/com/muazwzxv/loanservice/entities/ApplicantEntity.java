package com.muazwzxv.loanservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "applicant")
public class ApplicantEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "id")
    private Long id;

    @Column(name = "applicant_uuid")
    private String applicantUUID;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private String status;
}

