package com.muazwzxv.loanservice.service.offer;

import com.muazwzxv.loanservice.dto.OfferDto;
import com.muazwzxv.loanservice.service.offer.payload.CreateLoanRequest;
import com.muazwzxv.loanservice.service.offer.payload.CreateLoanResponse;
import com.muazwzxv.loanservice.service.offer.payload.UpdateOfferReq;
import com.muazwzxv.loanservice.service.offer.payload.UpdateOfferResp;

public interface IOfferService {
    OfferDto getOffer(String applicationUUID);
    CreateLoanResponse simulateLoanCreation(CreateLoanRequest createLoanRequest);
    UpdateOfferResp updateOffer(UpdateOfferReq req);
}
