package com.muazwzxv.cardservice.controllers.card;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class CardController {
    @PostMapping("/v1/card/activate")
    public ResponseEntity<Object> activateCard() {
        return null;
    }

    @PostMapping("/v1/card/disable")
    public ResponseEntity<Object> disableCard() {
        return null;
    }
}
