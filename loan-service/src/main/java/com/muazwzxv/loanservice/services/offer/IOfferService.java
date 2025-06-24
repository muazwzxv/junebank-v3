package com.muazwzxv.loanservice.services.offer;

import com.muazwzxv.loanservice.dto.OfferDto;
import com.muazwzxv.loanservice.services.offer.payload.CreateLoanRequest;
import com.muazwzxv.loanservice.services.offer.payload.CreateLoanResponse;
import com.muazwzxv.loanservice.services.offer.payload.UpdateOfferReq;
import com.muazwzxv.loanservice.services.offer.payload.UpdateOfferResp;

public interface IOfferService {
    OfferDto getOffer(String applicationUUID);
    CreateLoanResponse simulateLoanCreation(CreateLoanRequest createLoanRequest);
    UpdateOfferResp updateOffer(UpdateOfferReq req);
}
