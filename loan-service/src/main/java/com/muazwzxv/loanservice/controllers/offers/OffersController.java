package com.muazwzxv.loanservice.controllers.offers;

import com.muazwzxv.loanservice.controllers.offers.payload.SimulateOfferRequest;
import com.muazwzxv.loanservice.controllers.offers.payload.SimulateOfferResponse;
import com.muazwzxv.loanservice.dto.OfferDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OffersController {

    @PostMapping("/v1/simulate/offer")
    public ResponseEntity<SimulateOfferResponse> simulateOffer(
            @Valid @RequestBody SimulateOfferRequest request
    ) {
        // TODO: logic to simulate offer
        // - check if application exist
        // - create offer
        // - update application status, statusReason
        return null;
    }

    @GetMapping("/v1/offer")
    public ResponseEntity<OfferDto> getOffer(
            @RequestParam @NotEmpty(message = "uuid cannot be empty") String applicationUUID
    ) {
        // TODO: logic to query existing offer
        // - query db to get offer
        return null;
    }
}
