package com.muazwzxv.cardservice.services.design.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateDesignRequest {
    private String name;
    private String description;
}
