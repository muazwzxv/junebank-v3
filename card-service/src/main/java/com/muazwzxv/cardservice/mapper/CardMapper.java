package com.muazwzxv.cardservice.mapper;

import com.muazwzxv.cardservice.dto.CardDto;
import com.muazwzxv.cardservice.entities.CardEntity;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {
    public CardDto toDto(CardEntity card) {
        if (card == null)
            return null;

        return CardDto.builder()
            .cardUUID(card.getCardUUID())
            .customerUUID(card.getCustomerUUID())
            .designUUID(card.getDesignUUID())
            .status(card.getStatus())
            .createdAt(card.getCreatedAt())
            .createdBy(card.getCreatedBy())
            .updatedAt(card.getUpdatedAt())
            .updatedBy(card.getUpdatedBy())
            .build();
    }

    public CardEntity toEntity(CardDto dto) {
        if (dto == null) return null;

        CardEntity card = CardEntity.builder()
            .cardUUID(dto.getCardUUID())
            .customerUUID(dto.getCustomerUUID())
            .designUUID(dto.getDesignUUID())
            .status(dto.getStatus())
            .build();

        card.setCreatedAt(dto.getCreatedAt());
        card.setCreatedBy(dto.getCreatedBy());
        card.setUpdatedAt(dto.getUpdatedAt());
        card.setUpdatedBy(dto.getUpdatedBy());

        return card;
    }
}
