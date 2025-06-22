package com.muazwzxv.loanservice.controllers.applications;

import com.muazwzxv.loanservice.controllers.applications.payload.CreateLoanApplicationRespHttp;
import com.muazwzxv.loanservice.controllers.applications.payload.GetApplicationsRespHttp;
import com.muazwzxv.loanservice.dto.ApplicationDto;
import com.muazwzxv.loanservice.service.applicant.IApplicantService;
import com.muazwzxv.loanservice.service.application.IApplicationService;
import com.muazwzxv.loanservice.service.application.payload.CreateLoanApplicationResponse;
import com.muazwzxv.loanservice.service.offer.IOfferService;
import com.muazwzxv.loanservice.service.application.payload.CreateLoanApplicationRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class ApplicationsController {

    private IApplicationService applicationService;
    private IApplicantService applicantService;
    private IOfferService offerService;

    @PostMapping("/v1/application/create")
    public ResponseEntity<CreateLoanApplicationRespHttp> createLoanApplication(
            @Valid @RequestBody CreateLoanApplicationRequest loanApplication
    ) {
        CreateLoanApplicationRequest req = CreateLoanApplicationRequest.builder().
            email(loanApplication.getEmail())
            .applicantUUID(loanApplication.getApplicantUUID())
            .build();

        CreateLoanApplicationResponse resp = this.applicationService.createLoanApplication(req);
        return ResponseEntity.ok(
            CreateLoanApplicationRespHttp.builder()
                .applicationUUID(resp.getApplicationUUID())
                .status(resp.getStatus())
                .statusReason(resp.getStatusReason())
                .createdAt(resp.getCreatedAt().toString())
                .build());
    }

    @GetMapping("/v1/application/{applicationUUID}")
    public ResponseEntity<ApplicationDto> getApplicationByUUID(
            @PathVariable @NotEmpty(message = "uuid cannot be empty") String applicationUUID) {
        ApplicationDto applicationDto = this.applicationService.getApplication(applicationUUID);
        return ResponseEntity.ok(applicationDto);
    }

    @GetMapping("/v1/applications")
    public ResponseEntity<GetApplicationsRespHttp> getApplicationsByApplicantUUID(
            @RequestParam @NotEmpty(message = "uuid cannot be empty") String applicantUUID
    ) {
        List<ApplicationDto> applicationList = this.applicationService.getApplicationsByApplicantUUID(applicantUUID);
        return ResponseEntity.ok(
            GetApplicationsRespHttp.builder()
                .applications(applicationList)
                .build()
        );
    }
}
