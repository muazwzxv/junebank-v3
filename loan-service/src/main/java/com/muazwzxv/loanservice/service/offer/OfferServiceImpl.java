package com.muazwzxv.loanservice.service.offer;

import com.muazwzxv.loanservice.LoanServiceApplication;
import com.muazwzxv.loanservice.dto.OfferDto;
import com.muazwzxv.loanservice.entities.ApplicationEntity;
import com.muazwzxv.loanservice.entities.OfferEntity;
import com.muazwzxv.loanservice.exception.ResourceNotFoundException;
import com.muazwzxv.loanservice.exception.UnexpectedErrorException;
import com.muazwzxv.loanservice.exception.offerException.OfferPendingException;
import com.muazwzxv.loanservice.mapper.OfferMapper;
import com.muazwzxv.loanservice.repository.ApplicationRepository;
import com.muazwzxv.loanservice.repository.OfferRepository;
import com.muazwzxv.loanservice.service.offer.payload.CreateLoanRequest;
import com.muazwzxv.loanservice.service.offer.payload.CreateLoanResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;
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

        try {
            // check if offer exist
            Optional<OfferEntity> optionalOffer = this.offerRepository.findByApplicationUUID(req.getApplicationUUID());
            if (optionalOffer.isPresent()) {
                OfferEntity offerEntity = optionalOffer.get();
                log.error("Application: {} has an existing offer: {} with status: {}",
                    req.getApplicationUUID(),
                    offerEntity.getOfferUUID(),
                    offerEntity.getStatus());
                throw new OfferPendingException(offerEntity.getOfferUUID(), req.getApplicationUUID(), offerEntity.getStatus());
            }

            // check if application exist
            Optional<ApplicationEntity> optionalApplication = this.applicationRepository.findByApplicationUUID(req.getApplicationUUID());
            if (optionalApplication.isEmpty()) {
                log.error("Application not found with applicationUUID: {}", req.getApplicationUUID());
                throw new ResourceNotFoundException("Application", "applicationUUID", req.getApplicationUUID());
            }

            ApplicationEntity applicationEntity = optionalApplication.get();
            applicationEntity.setStatus("PENDING_ACCEPTANCE");
            applicationEntity.setStatusReason("OFFER_CREATED");

            OfferEntity offerEntity = OfferEntity.builder()
                .offerUUID(UUID.randomUUID().toString())
                .applicationUUID(applicationEntity.getApplicationUUID())
                .offeredInterest(this.getRandomInterest())
                .offeredLimit("50000")
                .status("PENDING_ACCEPTANCE")
                .build();

            // Save entities
            this.applicationRepository.saveAndFlush(applicationEntity);
            this.offerRepository.saveAndFlush(offerEntity);

            // Map to response
            return CreateLoanResponse.builder()
                .offer(this.offerMapper.toDto(offerEntity))
                .build();

        } catch (OfferPendingException | ResourceNotFoundException e) {
            // Re-throw business exceptions as-is
            throw e;
        } catch (DataAccessException e) {
            log.error("Database error during loan simulation for applicationUUID: {}", req.getApplicationUUID(), e);
            throw new UnexpectedErrorException("Database error during loan creation: " + e.getMessage(), e);
        } catch (Exception e) {
            log.error("Unexpected error during loan simulation for applicationUUID: {}", req.getApplicationUUID(), e);
            throw new UnexpectedErrorException("Unexpected error during loan creation: " + e.getMessage(), e);
        }
    }

    public String getRandomInterest() {
        float randomFloat = ThreadLocalRandom.current().nextFloat() * 20;
        return String.format("%.2f", randomFloat);
    }
}
