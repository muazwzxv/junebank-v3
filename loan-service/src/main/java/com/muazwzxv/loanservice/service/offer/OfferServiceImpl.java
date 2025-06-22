package com.muazwzxv.loanservice.service.offer;

import com.muazwzxv.loanservice.LoanServiceApplication;
import com.muazwzxv.loanservice.dto.OfferDto;
import com.muazwzxv.loanservice.service.offer.payload.CreateLoanRequest;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OfferServiceImpl implements IOfferService{
    private static final Logger log = LoggerFactory.getLogger(LoanServiceApplication.class);

    @Override
    public OfferDto getOffer(String applicationUUID) {
        return null;
    }

    @Override
    public CreateLoanRequest simulateLoanCreation(CreateLoanRequest createLoanRequest) {
        return null;
    }
}
