package com.muazwzxv.cardservice.services.design;

import com.muazwzxv.cardservice.dto.DesignDto;
import com.muazwzxv.cardservice.services.design.payload.CreateDesignRequest;
import com.muazwzxv.cardservice.services.design.payload.CreateDesignResponse;
import com.muazwzxv.cardservice.services.design.payload.UpdateDesignRequest;

public interface IDesignService {
    CreateDesignResponse createDesign(CreateDesignRequest req);
    DesignDto updateDesign(UpdateDesignRequest req);
    DesignDto getDesignByDesignUUID(String designUUID);
}
