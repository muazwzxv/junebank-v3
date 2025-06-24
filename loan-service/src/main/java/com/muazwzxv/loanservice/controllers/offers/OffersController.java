package com.muazwzxv.loanservice.controllers.offers;

import com.muazwzxv.loanservice.controllers.offers.Http.SimulateOfferReqHttp;
import com.muazwzxv.loanservice.controllers.offers.Http.SimulateOfferRespHttp;
import com.muazwzxv.loanservice.controllers.offers.Http.UpdateOfferReqHttp;
import com.muazwzxv.loanservice.controllers.offers.Http.UpdateOfferRespHttp;
import com.muazwzxv.loanservice.dto.OfferDto;
import com.muazwzxv.loanservice.services.offer.IOfferService;
import com.muazwzxv.loanservice.services.offer.payload.CreateLoanRequest;
import com.muazwzxv.loanservice.services.offer.payload.CreateLoanResponse;
import com.muazwzxv.loanservice.services.offer.payload.UpdateOfferReq;
import com.muazwzxv.loanservice.services.offer.payload.UpdateOfferResp;
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
    public ResponseEntity<SimulateOfferRespHttp> simulateOffer(
            @Valid @RequestBody SimulateOfferReqHttp request
    ) {
        CreateLoanResponse resp = this.offerService.simulateLoanCreation(CreateLoanRequest.builder()
            .applicationUUID(request.getApplicationUUID())
            .build());

        return ResponseEntity.ok(SimulateOfferRespHttp.builder()
            .offer(resp.getOffer())
            .build());
    }

    @GetMapping("/v1/offer")
    public ResponseEntity<OfferDto> getOffer(
            @RequestParam @NotEmpty(message = "uuid cannot be empty") String applicationUUID
    ) {
        OfferDto offer = this.offerService.getOffer(applicationUUID);
        return ResponseEntity.ok(offer);
    }

    @PutMapping("/v1/offer")
    public ResponseEntity<UpdateOfferRespHttp> updateOffer(
        @Valid @RequestBody UpdateOfferReqHttp request
    ) {
        UpdateOfferReq req = UpdateOfferReq.builder()
            .offerUUID(request.getOfferUUID())
            .status(request.getStatus())
            .build();
        UpdateOfferResp resp = this.offerService.updateOffer(req);
        return ResponseEntity.ok(UpdateOfferRespHttp.builder()
            .offer(resp.getOffer())
            .build());
    }
}
