package com.muazwzxv.loanservice.controllers.applications.Http;

import com.muazwzxv.loanservice.dto.ApplicationDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetApplicationsRespHttp {
    private List<ApplicationDto> applications;
}
