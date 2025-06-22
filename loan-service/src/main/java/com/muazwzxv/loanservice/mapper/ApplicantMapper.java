package com.muazwzxv.loanservice.mapper;

import com.muazwzxv.loanservice.dto.ApplicantDto;
import com.muazwzxv.loanservice.entities.ApplicantEntity;
import org.springframework.stereotype.Component;

@Component
public class ApplicantMapper {
    public ApplicantDto toDto(ApplicantEntity applicant) {
        if (applicant == null) return null;

        return ApplicantDto.builder()
            .applicantUUID(applicant.getApplicantUUID())
            .email(applicant.getEmail())
            .status(applicant.getStatus())
            .createdAt(applicant.getCreatedAt())
            .createdBy(applicant.getCreatedBy())
            .updatedAt(applicant.getUpdatedAt())
            .updatedBy(applicant.getUpdatedBy())
            .build();
    }

    public ApplicantEntity toEntity(ApplicantDto dto) {
        if (dto == null) return null;

        ApplicantEntity applicant = ApplicantEntity.builder()
            .applicantUUID(dto.getApplicantUUID())
            .email(dto.getEmail())
            .status(dto.getStatus())
            .build();

        applicant.setCreatedAt(dto.getCreatedAt());
        applicant.setCreatedBy(dto.getCreatedBy());
        applicant.setUpdatedAt(dto.getUpdatedAt());
        applicant.setUpdatedBy(dto.getUpdatedBy());


        return applicant;
    }

//    public void updateEntityFromDto(UserDto dto, User user) {
//        user.setName(dto.getName());
//        user.setEmail(dto.getEmail());
//        // Don't update ID or timestamps
//    }
}
