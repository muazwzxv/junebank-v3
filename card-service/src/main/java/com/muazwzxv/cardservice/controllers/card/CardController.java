package com.muazwzxv.cardservice.controllers.card;

import com.muazwzxv.cardservice.controllers.card.Http.ActivateCardReqHttp;
import com.muazwzxv.cardservice.controllers.card.Http.DisableCardReqHttp;
import com.muazwzxv.cardservice.controllers.card.Http.ListCardRespHttp;
import com.muazwzxv.cardservice.dto.CardDto;
import com.muazwzxv.cardservice.services.card.ICardService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class CardController {
    private ICardService cardService;

    @GetMapping("/v1/card/{cardUUID}")
    public ResponseEntity<CardDto> getCardByUUID(
        @Valid @PathVariable @NotEmpty(message = "uuid cannot be empty") String cardUUID
    ) {
        return ResponseEntity.ok(
            this.cardService.getCard(cardUUID)
        );
    }

    @GetMapping("/v1/cards")
    public ResponseEntity<ListCardRespHttp> listCustomerCards(
        @Valid @RequestParam @NotEmpty(message = "uuid cannot be empty") String customerUUID
    ) {
        List<CardDto> cardDtoList = this.cardService.getCustomersCard(customerUUID);
        return ResponseEntity.ok(ListCardRespHttp.builder()
            .cards(cardDtoList)
            .build());
    }

    @PostMapping("/v1/card/activate")
    public ResponseEntity<CardDto> activateCard(
        @Valid @RequestBody ActivateCardReqHttp req
    ) {
        CardDto cardDto = this.cardService.activateCard(req.getCardUUID());
        return ResponseEntity.ok(cardDto);
    }

    @PostMapping("/v1/card/disable")
    public ResponseEntity<CardDto> disableCard(
        @Valid @RequestBody DisableCardReqHttp req
    ) {
        CardDto cardDto = this.cardService.disableCard(req.getCardUUID());
        return ResponseEntity.ok(cardDto);
    }
}
