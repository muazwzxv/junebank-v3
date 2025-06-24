package com.muazwzxv.cardservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "design")
public class DesignEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "id")
    private Long id;

    @Column(name = "design_uuid")
    private String designUUId;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;
}
