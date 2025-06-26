package com.muazwzxv.cardservice.controllers.order;

import com.muazwzxv.cardservice.controllers.order.Http.SubmitOrderReqHttp;
import com.muazwzxv.cardservice.controllers.order.Http.SubmitOrderRespHttp;
import com.muazwzxv.cardservice.services.order.IOrderService;
import com.muazwzxv.cardservice.services.order.payload.SubmitOrderRequest;
import com.muazwzxv.cardservice.services.order.payload.SubmitOrderResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class OrderController {

    private IOrderService orderService;

    @PostMapping("/v1/card-order")
    public ResponseEntity<SubmitOrderRespHttp> submitOrder(
        @Valid @RequestBody SubmitOrderReqHttp req
    ) {
        SubmitOrderRequest arg = SubmitOrderRequest.builder()
            .customerUUID(req.getCustomerUUID())
            .designUUID(req.getDesignUUID())
            .build();

        SubmitOrderResponse resp = this.orderService.submitOrder(arg);
        return ResponseEntity.ok(
            SubmitOrderRespHttp.builder()
                .orderUUID(resp.getOrderUUID())
                .build()
        );
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
