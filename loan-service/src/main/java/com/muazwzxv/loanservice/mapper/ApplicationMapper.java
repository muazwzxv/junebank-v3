package com.muazwzxv.loanservice.mapper;

import com.muazwzxv.loanservice.dto.ApplicationDto;
import com.muazwzxv.loanservice.entities.ApplicationEntity;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties;
import org.springframework.stereotype.Component;

@Component
public class ApplicationMapper {
    public ApplicationDto toDto(ApplicationEntity entity)  {
        if (entity == null) {
            return null;
        }

        return ApplicationDto.builder()
            .applicationUUID(entity.getApplicationUUID())
            .applicantUUID(entity.getApplicantUUID())
            .status(entity.getStatus())
            .statusReason(entity.getStatusReason())
            .createdAt(entity.getCreatedAt())
            .createdBy(entity.getCreatedBy())
            .updatedAt(entity.getUpdatedAt())
            .updatedBy(entity.getUpdatedBy())
            .build();
    }

    public ApplicationEntity toEntity(ApplicationDto dto) {
        if (dto == null) {
            return null;
        }

        ApplicationEntity application = ApplicationEntity.builder()
            .applicationUUID(dto.getApplicationUUID())
            .applicantUUID(dto.getApplicantUUID())
            .status(dto.getStatus())
            .statusReason(dto.getStatusReason())
            .build();

        application.setCreatedAt(dto.getCreatedAt());
        application.setCreatedBy(dto.getCreatedBy());
        application.setUpdatedAt(dto.getUpdatedAt());
        application.setUpdatedBy(dto.getUpdatedBy());
        return application;
    }
}
