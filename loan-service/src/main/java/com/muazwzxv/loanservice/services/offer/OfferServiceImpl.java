package com.muazwzxv.loanservice.services.offer;

import com.muazwzxv.loanservice.LoanServiceApplication;
import com.muazwzxv.loanservice.dto.OfferDto;
import com.muazwzxv.loanservice.entities.ApplicationEntity;
import com.muazwzxv.loanservice.entities.OfferEntity;
import com.muazwzxv.loanservice.enums.application.ApplicationStatus;
import com.muazwzxv.loanservice.enums.application.ApplicationStatusReason;
import com.muazwzxv.loanservice.enums.offer.OfferStatus;
import com.muazwzxv.loanservice.exceptions.BadInputException;
import com.muazwzxv.loanservice.exceptions.ResourceNotFoundException;
import com.muazwzxv.loanservice.exceptions.offerException.OfferInvalidStatusException;
import com.muazwzxv.loanservice.exceptions.offerException.OfferPendingException;
import com.muazwzxv.loanservice.mapper.OfferMapper;
import com.muazwzxv.loanservice.repositories.ApplicationRepository;
import com.muazwzxv.loanservice.repositories.OfferRepository;
import com.muazwzxv.loanservice.services.offer.payload.CreateLoanRequest;
import com.muazwzxv.loanservice.services.offer.payload.CreateLoanResponse;
import com.muazwzxv.loanservice.services.offer.payload.UpdateOfferReq;
import com.muazwzxv.loanservice.services.offer.payload.UpdateOfferResp;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
@AllArgsConstructor
public class OfferServiceImpl implements IOfferService{
    private static final Logger log = LoggerFactory.getLogger(LoanServiceApplication.class);
    private OfferRepository offerRepository;
    private ApplicationRepository applicationRepository;
    private OfferMapper offerMapper;

    @Override
    public OfferDto getOffer(String applicationUUID) {
        log.info("get offer request with applicationUUID: {}", applicationUUID);
        OfferEntity offer = this.offerRepository.findByApplicationUUID(applicationUUID).orElseThrow(
            () -> new ResourceNotFoundException("Offer", "applicationUUID", applicationUUID)
        );
        return this.offerMapper.toDto(offer);
    }

    @Override
    @Transactional
    public CreateLoanResponse simulateLoanCreation(CreateLoanRequest req) {
        log.info("simulate create offer request with applicationUUID: {}", req.getApplicationUUID());
        // check if offer exist
        Optional<OfferEntity> optionalOffer = this.offerRepository.findByApplicationUUID(req.getApplicationUUID());
        if (optionalOffer.isPresent()) {
            OfferEntity offerEntity = optionalOffer.get();
            log.error("Application: {} has an existing offer: {} with status: {}",
                req.getApplicationUUID(),
                offerEntity.getOfferUUID(),
                offerEntity.getStatus());
            throw new OfferPendingException(offerEntity.getOfferUUID(), req.getApplicationUUID());
        }

        // check if application exist
        Optional<ApplicationEntity> optionalApplication = this.applicationRepository.findByApplicationUUID(req.getApplicationUUID());
        if (optionalApplication.isEmpty()) {
            log.error("Application not found with applicationUUID: {}", req.getApplicationUUID());
            throw new ResourceNotFoundException("Application", "applicationUUID", req.getApplicationUUID());
        }

        ApplicationEntity applicationEntity = optionalApplication.get();
        applicationEntity.setStatus(ApplicationStatus.PENDING_ACCEPTANCE.getValue());
        applicationEntity.setStatusReason(ApplicationStatusReason.OFFER_CREATED.getValue());

        OfferEntity offerEntity = OfferEntity.builder()
            .offerUUID(UUID.randomUUID().toString())
            .applicationUUID(applicationEntity.getApplicationUUID())
            .offeredInterest(this.getRandomInterest())
            .offeredLimit("50000")
            .status(OfferStatus.PENDING_ACCEPTANCE.getValue())
            .build();

        // Save entities
        this.applicationRepository.saveAndFlush(applicationEntity);
        this.offerRepository.saveAndFlush(offerEntity);

        // Map to response
        return CreateLoanResponse.builder()
            .offer(this.offerMapper.toDto(offerEntity))
            .build();
    }

    @Override
    @Transactional
    public UpdateOfferResp updateOffer(UpdateOfferReq req) {
        log.info("update offer request with offer: {}", req.getOfferUUID());

        // no nice way to do it at controller level, imma park it here first
        Set<String> validStatuses = Set.of(
            OfferStatus.OFFER_ACCEPTED.getValue(),
            OfferStatus.OFFER_DECLINED.getValue()
        );
        if (validStatuses.contains(req.getStatus())) {
            log.warn("not a valid status, {}", req.getStatus());
            throw new BadInputException("Offer", "status", req.getStatus());
        }

        Optional<OfferEntity> optionalOfferEntity = this.offerRepository.findByOfferUUID(req.getOfferUUID());
        if (optionalOfferEntity.isEmpty()) {
            log.error("offer: {} does not exist", req.getOfferUUID());
            throw new ResourceNotFoundException("Offer", "offerUUID", req.getOfferUUID());
        }
        OfferEntity offerEntity = optionalOfferEntity.get();

        if (!Objects.equals(
            offerEntity.getStatus(),
            OfferStatus.PENDING_ACCEPTANCE.getValue())
        ) {
            log.warn("offer: {} is in an invalid state: {}", req.getOfferUUID(), offerEntity.getStatus());
            throw new OfferInvalidStatusException(req.getOfferUUID());
        }

        Optional<ApplicationEntity> optionalApplicationEntity = this.applicationRepository.findByApplicationUUID(offerEntity.getApplicationUUID());
        if (optionalApplicationEntity.isEmpty()) {
            log.error("offer: {} corresponding application is missing, application: {}", offerEntity.getOfferUUID(), offerEntity.getApplicationUUID());
            throw new ResourceNotFoundException("Application", "applicationUUID", offerEntity.getApplicationUUID());
        }
        ApplicationEntity applicationEntity = optionalApplicationEntity.get();

        if (Objects.equals(req.getStatus(), OfferStatus.OFFER_ACCEPTED.getValue())) {
            offerEntity.setStatus(OfferStatus.OFFER_ACCEPTED.getValue());
            applicationEntity.setStatus(ApplicationStatus.ACCEPTED.getValue());
            applicationEntity.setStatusReason(ApplicationStatusReason.APPROVED.getValue());
        } else {
            offerEntity.setStatus(OfferStatus.OFFER_DECLINED.getValue());
            applicationEntity.setStatus(ApplicationStatus.REJECTED.getValue());
            applicationEntity.setStatusReason(ApplicationStatusReason.REJECTED.getValue());
        }

        this.offerRepository.saveAndFlush(offerEntity);
        this.applicationRepository.save(applicationEntity);

        return UpdateOfferResp.builder()
            .offer(this.offerMapper.toDto(offerEntity))
            .build();
    }

    public String getRandomInterest() {
        float randomFloat = ThreadLocalRandom.current().nextFloat() * 20;
        return String.format("%.2f", randomFloat);
    }
}
