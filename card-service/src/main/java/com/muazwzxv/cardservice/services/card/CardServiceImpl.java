package com.muazwzxv.cardservice.services.card;

import com.muazwzxv.cardservice.dto.CardDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CardServiceImpl implements ICardService{
    @Override
    public CardDto activateCard(String cardUUID) {
        return null;
    }

    @Override
    public CardDto disableCard(String cardUUID) {
        return null;
    }
}
