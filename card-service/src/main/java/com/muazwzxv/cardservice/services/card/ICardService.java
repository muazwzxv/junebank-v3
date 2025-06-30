package com.muazwzxv.cardservice.services.card;

import com.muazwzxv.cardservice.dto.CardDto;

import java.util.List;

public interface ICardService {
    CardDto activateCard(String cardUUID);
    CardDto disableCard(String cardUUID);
    CardDto getCard(String cardUUID);
    List<CardDto> getCustomersCard(String customerUUID);
}
