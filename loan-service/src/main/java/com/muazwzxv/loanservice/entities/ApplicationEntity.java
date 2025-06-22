package com.muazwzxv.loanservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "application")
public class ApplicationEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "id")
    private Long id;

    @Column(name = "applicant_uuid")
    private String applicantUUID;

    @Column(name = "application_uuid")
    private String applicationUUID;

    @Column(name = "status")
    private String status;

    @Column(name = "status_reason")
    private String statusReason;
}
