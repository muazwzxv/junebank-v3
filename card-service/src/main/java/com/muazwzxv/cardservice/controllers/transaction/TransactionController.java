package com.muazwzxv.cardservice.controllers.transaction;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class TransactionController {
    @PostMapping("/v1/card-transaction/charge")
    public ResponseEntity<Object> chargeTransaction() {
        return null;
    }

    @PostMapping("/v1/card-transaction/refund")
    public ResponseEntity<Object> refundTransaction() {
        return null;
    }
}
