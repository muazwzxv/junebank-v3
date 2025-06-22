package com.muazwzxv.loanservice.service.offer;

import com.muazwzxv.loanservice.dto.OfferDto;
import com.muazwzxv.loanservice.service.offer.payload.CreateLoanRequest;
import com.muazwzxv.loanservice.service.offer.payload.CreateLoanResponse;

public interface IOfferService {
    OfferDto getOffer(String applicationUUID);
    CreateLoanResponse simulateLoanCreation(CreateLoanRequest createLoanRequest);
}
