package com.muazwzxv.cardservice.controllers.transaction;

import com.muazwzxv.cardservice.controllers.transaction.Http.TransactionReqHttp;
import com.muazwzxv.cardservice.controllers.transaction.Http.TransactionRespHttp;
import com.muazwzxv.cardservice.dto.TransactionDto;
import com.muazwzxv.cardservice.services.transaction.ITransactionService;
import com.muazwzxv.cardservice.services.transaction.payload.TransactionRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class TransactionController {

    private ITransactionService transactionService;

    @PostMapping("/v1/card-transaction/execute")
    public ResponseEntity<TransactionRespHttp> chargeTransaction(
        @Valid @RequestBody TransactionReqHttp req
    ) {
        TransactionRequest arg = TransactionRequest.builder()
            .cardUUID(req.getCardUUID())
            .transactionType(req.getTransactionType())
            .amount(req.getAmount())
            .build();

        TransactionDto transaction = this.transactionService.triggerTransaction(arg);
        return ResponseEntity.ok(TransactionRespHttp.builder()
            .cardUUID(req.getCardUUID())
            .transaction(transaction)
            .build());
    }

    @PostMapping("/v1/card-transaction/refund")
    public ResponseEntity<TransactionRespHttp> refundTransaction(
        @Valid @RequestBody TransactionReqHttp req
    ) {
        TransactionRequest arg = TransactionRequest.builder()
            .cardUUID(req.getCardUUID())
            .transactionType(req.getTransactionType())
            .amount(req.getAmount())
            .build();

        TransactionDto transaction = this.transactionService.triggerTransaction(arg);
        return ResponseEntity.ok(TransactionRespHttp.builder()
            .cardUUID(req.getCardUUID())
            .transaction(transaction)
            .build());
    }
}
