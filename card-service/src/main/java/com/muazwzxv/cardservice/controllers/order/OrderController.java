package com.muazwzxv.cardservice.controllers.order;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class OrderController {

    @PostMapping("/v1/order")
    public ResponseEntity<Object> submitOrder() {
        return null;
    }

    @GetMapping("/v1/order/{customerUUID}")
    public ResponseEntity<Object> getCardOrder() {
        return null;
    }

    @PostMapping("/v1/simulate-order/complete")
    public ResponseEntity<Object> simulateOrderCompleted() {
        return null;
    }
}
