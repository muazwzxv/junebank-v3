package com.muazwzxv.loanservice.service.offer;

import com.muazwzxv.loanservice.dto.OfferDto;
import com.muazwzxv.loanservice.service.offer.payload.CreateLoanRequest;

public interface IOfferService {
    OfferDto getOffer(String applicationUUID);
    CreateLoanRequest simulateLoanCreation(CreateLoanRequest createLoanRequest);
}
