package com.muazwzxv.loanservice.mapper;

import com.muazwzxv.loanservice.dto.OfferDto;
import com.muazwzxv.loanservice.entities.OfferEntity;
import org.springframework.stereotype.Component;

@Component
public class OfferMapper {
    public OfferDto toDto(OfferEntity entity) {
        if (entity == null) {
            return null;
        }

        return OfferDto.builder()
            .applicationUUID(entity.getApplicationUUID())
            .offeredInterest(entity.getOfferedInterest())
            .offeredLimit(entity.getOfferedLimit())
            .status(entity.getStatus())
            .createdAt(entity.getCreatedAt())
            .createdBy(entity.getCreatedBy())
            .updatedAt(entity.getUpdatedAt())
            .updatedBy(entity.getUpdatedBy())
            .build();
    }

    public OfferEntity toEntity(OfferDto dto) {
        if (dto == null) {
            return null;
        }

        OfferEntity offer = OfferEntity.builder()
            .applicationUUID(dto.getApplicationUUID())
            .offeredInterest(dto.getOfferedInterest())
            .offeredLimit(dto.getOfferedLimit())
            .status(dto.getStatus())
            .build();

        offer.setCreatedAt(dto.getCreatedAt());
        offer.setCreatedBy(dto.getCreatedBy());
        offer.setUpdatedAt(dto.getUpdatedAt());
        offer.setUpdatedBy(dto.getUpdatedBy());

        return offer;
    }
}
