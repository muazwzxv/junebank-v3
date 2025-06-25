package com.muazwzxv.cardservice.mapper;

import com.muazwzxv.cardservice.dto.DesignDto;
import com.muazwzxv.cardservice.entities.DesignEntity;
import org.springframework.stereotype.Component;

@Component
public class DesignMapper {
    public DesignDto toDto(DesignEntity design) {
        if (design == null) return null;

        return DesignDto.builder()
            .designUUId(design.getDesignUUId())
            .name(design.getName())
            .description(design.getDescription())
            .status(design.getStatus())
            .createdAt(design.getCreatedAt())
            .createdBy(design.getCreatedBy())
            .updatedAt(design.getUpdatedAt())
            .updatedBy(design.getUpdatedBy())
            .build();
    }

    public DesignEntity toEntity(DesignDto dto) {
        if (dto == null) return null;

        DesignEntity design = DesignEntity.builder()
            .designUUId(dto.getDesignUUId())
            .name(dto.getName())
            .description(dto.getDescription())
            .status(dto.getStatus())
            .build();

        design.setCreatedAt(dto.getCreatedAt());
        design.setCreatedBy(dto.getCreatedBy());
        design.setUpdatedAt(dto.getUpdatedAt());
        design.setUpdatedBy(dto.getUpdatedBy());

        return design;
    }
}
