package com.muazwzxv.cardservice.services.design.payload;

import com.muazwzxv.cardservice.dto.DesignDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateDesignResponse {
    private DesignDto design;
}
