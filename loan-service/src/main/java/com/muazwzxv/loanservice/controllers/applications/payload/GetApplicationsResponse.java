package com.muazwzxv.loanservice.controllers.applications.payload;

import com.muazwzxv.loanservice.dto.application.ApplicationDto;
import lombok.Data;

import java.util.List;

@Data
public class GetApplicationsResponse {
    private List<ApplicationDto> applications;
}
