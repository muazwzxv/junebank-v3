package com.muazwzxv.cardservice.services.card;

import com.muazwzxv.cardservice.dto.CardDto;
import com.muazwzxv.cardservice.entities.CardEntity;
import com.muazwzxv.cardservice.enums.card.CardStatus;
import com.muazwzxv.cardservice.exceptions.ResourceNotFoundException;
import com.muazwzxv.cardservice.exceptions.UnexpectedErrorException;
import com.muazwzxv.cardservice.mapper.CardMapper;
import com.muazwzxv.cardservice.repositories.CardRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class CardServiceImpl implements ICardService{
    private CardRepository cardRepository;
    private CardMapper cardMapper;

    @Override
    @Transactional
    public CardDto activateCard(String cardUUID) {
        log.info("activating card: {}", cardUUID);

        CardEntity cardEntity = this.cardRepository.findByCardUUID(cardUUID).orElseThrow(
            () -> new ResourceNotFoundException("Card", "cardUUID", cardUUID)
        );

        try {
            cardEntity.setStatus(CardStatus.CARD_ACTIVE.getValue());
            this.cardRepository.saveAndFlush(cardEntity);

            return this.cardMapper.toDto(cardEntity);
        } catch (Exception ex) {
            log.error("unexpected error activating card, error: {}", ex.getMessage());
            throw new UnexpectedErrorException(ex.getMessage(), ex);
        }
    }

    @Override
    public CardDto disableCard(String cardUUID) {
        log.info("disabling card: {}", cardUUID);

        CardEntity cardEntity = this.cardRepository.findByCardUUID(cardUUID).orElseThrow(
            () -> new ResourceNotFoundException("Card", "cardUUID", cardUUID)
        );

        try {
            cardEntity.setStatus(CardStatus.CARD_CANCELLED.getValue());
            this.cardRepository.saveAndFlush(cardEntity);

            return this.cardMapper.toDto(cardEntity);
        } catch (Exception ex) {
            log.error("unexpected error disabling card, error: {}", ex.getMessage());
            throw new UnexpectedErrorException(ex.getMessage(), ex);
        }
    }

    @Override
    public CardDto getCard(String cardUUID) {
        log.info("get card: {}", cardUUID);

        CardEntity cardEntity = this.cardRepository.findByCardUUID(cardUUID).orElseThrow(
            () -> new ResourceNotFoundException("Card", "cardUUID", cardUUID)
        );
        return this.cardMapper.toDto(cardEntity);
    }

    @Override
    public List<CardDto> getCustomersCard(String customerUUID) {
        log.info("listing cards for customer: {}", customerUUID);

        return this.cardRepository.findAllByCustomerUUID(customerUUID)
            .stream()
            .map(this.cardMapper::toDto)
            .collect(Collectors.toList());
    }
}
