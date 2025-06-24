package com.muazwzxv.cardservice.services.card;

import com.muazwzxv.cardservice.dto.CardDto;

public interface ICardService {
    CardDto activateCard(String cardUUID);
    CardDto disableCard(String cardUUID);
}
