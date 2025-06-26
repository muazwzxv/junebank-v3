package com.muazwzxv.cardservice.services.design;

import com.muazwzxv.cardservice.dto.DesignDto;
import com.muazwzxv.cardservice.entities.DesignEntity;
import com.muazwzxv.cardservice.exceptions.ResourceNotFoundException;
import com.muazwzxv.cardservice.exceptions.UnexpectedErrorException;
import com.muazwzxv.cardservice.mapper.DesignMapper;
import com.muazwzxv.cardservice.repositories.DesignRepository;
import com.muazwzxv.cardservice.services.design.payload.CreateDesignRequest;
import com.muazwzxv.cardservice.services.design.payload.CreateDesignResponse;
import com.muazwzxv.cardservice.services.design.payload.UpdateDesignRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class DesignServiceImpl implements IDesignService{
    private DesignRepository designRepository;
    private DesignMapper designMapper;

    @Override
    public CreateDesignResponse createDesign(CreateDesignRequest req) {
        try {
            DesignEntity designEntity = DesignEntity.builder()
                .designUUID(UUID.randomUUID().toString())
                .name(req.getName())
                .description(req.getDescription())
                .status("ACTIVE")
                .build();

            this.designRepository.saveAndFlush(designEntity);
            return CreateDesignResponse.builder()
                .design(designMapper.toDto(designEntity)) // TODO: assign the value
                .build();
        } catch (Exception ex) {
            log.error("unexpected error when creating design", ex);
            throw new UnexpectedErrorException("UNEXPECTED_ERROR", ex);
        }
    }

    @Override
    public DesignDto updateDesign(UpdateDesignRequest req) {
        return null;
    }

    @Override
    public DesignDto getDesignByDesignUUID(String designUUID) {
        DesignEntity designEntity = this.designRepository.findByDesignUUID(designUUID).orElseThrow(
            () -> new ResourceNotFoundException("Design", "designUUID", designUUID)
        );
        return this.designMapper.toDto(designEntity);
    }
}
