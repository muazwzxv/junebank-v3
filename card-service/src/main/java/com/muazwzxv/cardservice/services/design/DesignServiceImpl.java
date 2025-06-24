package com.muazwzxv.cardservice.services.design;

import com.muazwzxv.cardservice.dto.DesignDto;
import com.muazwzxv.cardservice.repositories.DesignRepository;
import com.muazwzxv.cardservice.services.design.payload.CreateDesignRequest;
import com.muazwzxv.cardservice.services.design.payload.CreateDesignResponse;
import com.muazwzxv.cardservice.services.design.payload.UpdateDesignRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class DesignServiceImpl implements IDesignService{
    private DesignRepository designRepository;

    @Override
    public CreateDesignResponse createDesign(CreateDesignRequest req) {
        return null;
    }

    @Override
    public DesignDto updateDesign(UpdateDesignRequest req) {
        return null;
    }

    @Override
    public DesignDto getDesignByCardUUID(String designUUID) {
        return null;
    }
}
