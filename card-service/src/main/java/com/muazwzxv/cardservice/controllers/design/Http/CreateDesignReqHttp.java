package com.muazwzxv.cardservice.controllers.design.Http;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateDesignReqHttp {
    @NotEmpty(message = "name cannot be empty")
    private String name;
    private String description;
}
