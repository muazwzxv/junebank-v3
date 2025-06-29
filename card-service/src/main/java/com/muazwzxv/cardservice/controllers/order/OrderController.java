package com.muazwzxv.cardservice.controllers.order;

import com.muazwzxv.cardservice.controllers.order.Http.SimulateOrderCompleteReqHttp;
import com.muazwzxv.cardservice.controllers.order.Http.SimulateOrderCompleteRespHttp;
import com.muazwzxv.cardservice.controllers.order.Http.SubmitOrderReqHttp;
import com.muazwzxv.cardservice.controllers.order.Http.SubmitOrderRespHttp;
import com.muazwzxv.cardservice.dto.OrderDto;
import com.muazwzxv.cardservice.services.order.IOrderService;
import com.muazwzxv.cardservice.services.order.payload.SimulateOrderCompleteRequest;
import com.muazwzxv.cardservice.services.order.payload.SimulateOrderCompleteResponse;
import com.muazwzxv.cardservice.services.order.payload.SubmitOrderRequest;
import com.muazwzxv.cardservice.services.order.payload.SubmitOrderResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
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

    @GetMapping("/v1/card-order/{orderUUID}")
    public ResponseEntity<OrderDto> getCardOrder(
        @Valid @PathVariable @NotEmpty(message = "uuid cannot be empty") String orderUUID
    ) {
        return ResponseEntity.ok(
            this.orderService.getOrderByOrderUUID(orderUUID)
        );
    }

    @PostMapping("/v1/simulate-card-order/complete")
    public ResponseEntity<SimulateOrderCompleteRespHttp> simulateOrderCompleted(
        @Valid @RequestBody SimulateOrderCompleteReqHttp req
    ) {
        SimulateOrderCompleteRequest arg = SimulateOrderCompleteRequest.builder()
            .orderUUID(req.getOrderUUID())
            .build();
        SimulateOrderCompleteResponse resp = this.orderService.simulateOrderComplete(arg);
        return ResponseEntity.ok(SimulateOrderCompleteRespHttp.builder()
            .cardUUID(resp.getCardUUID())
            .status(resp.getStatus())
            .order(resp.getOrder())
            .build());
    }
}
