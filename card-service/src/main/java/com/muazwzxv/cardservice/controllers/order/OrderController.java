package com.muazwzxv.cardservice.controllers.order;

import com.muazwzxv.cardservice.controllers.order.Http.SubmitOrderReqHttp;
import com.muazwzxv.cardservice.controllers.order.Http.SubmitOrderRespHttp;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class OrderController {

    @PostMapping("/v1/card-order")
    public ResponseEntity<SubmitOrderRespHttp> submitOrder(
        @Valid @RequestBody SubmitOrderReqHttp req
    ) {
        return null;
    }

    @GetMapping("/v1/card-order/{customerUUID}")
    public ResponseEntity<Object> getCardOrder() {
        return null;
    }

    @PostMapping("/v1/simulate-card-order/complete")
    public ResponseEntity<Object> simulateOrderCompleted() {
        return null;
    }
}
