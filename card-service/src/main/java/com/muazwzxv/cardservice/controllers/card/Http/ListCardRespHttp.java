package com.muazwzxv.cardservice.controllers.card.Http;

import com.muazwzxv.cardservice.dto.CardDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ListCardRespHttp {
    List<CardDto> cards;
}
