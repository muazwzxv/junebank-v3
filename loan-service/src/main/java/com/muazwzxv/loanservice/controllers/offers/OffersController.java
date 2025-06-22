package com.muazwzxv.loanservice.controllers.offers;

import com.muazwzxv.loanservice.controllers.offers.payload.SimulateOfferRequestHttp;
import com.muazwzxv.loanservice.controllers.offers.payload.SimulateOfferResponseHttp;
import com.muazwzxv.loanservice.dto.OfferDto;
import com.muazwzxv.loanservice.service.offer.IOfferService;
import com.muazwzxv.loanservice.service.offer.payload.CreateLoanRequest;
import com.muazwzxv.loanservice.service.offer.payload.CreateLoanResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class OffersController {

    private IOfferService offerService;

    @PostMapping("/v1/simulate/offer")
    public ResponseEntity<SimulateOfferResponseHttp> simulateOffer(
            @Valid @RequestBody SimulateOfferRequestHttp request
    ) {
        CreateLoanResponse resp = this.offerService.simulateLoanCreation(CreateLoanRequest.builder()
            .applicationUUID(request.getApplicationUUID())
            .build());

        return ResponseEntity.ok(SimulateOfferResponseHttp.builder()
            .offer(resp.getOffer())
            .build());
    }

    @GetMapping("/v1/offer")
    public ResponseEntity<OfferDto> getOffer(
            @RequestParam @NotEmpty(message = "uuid cannot be empty") String applicationUUID
    ) {
        // TODO: logic to query existing offer
        return null;
    }
}
