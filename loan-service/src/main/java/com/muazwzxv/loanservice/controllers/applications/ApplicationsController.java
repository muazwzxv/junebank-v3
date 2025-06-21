package com.muazwzxv.loanservice.controllers.applications;

import com.muazwzxv.loanservice.controllers.applications.payload.CreateLoanApplicationResponse;
import com.muazwzxv.loanservice.controllers.applications.payload.GetApplicationsResponse;
import com.muazwzxv.loanservice.dto.application.ApplicationDto;
import jakarta.validation.Valid;
import com.muazwzxv.loanservice.controllers.applications.payload.CreateLoanApplicationRequest;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class ApplicationsController {

    @PostMapping("/v1/application/create")
    public ResponseEntity<CreateLoanApplicationResponse> createLoanApplication(
            @Valid @RequestBody CreateLoanApplicationRequest loanApplication
    ) {
        // TODO: logic for creating loans
        // 1 - verify if applicant information exists,
        //     insert if exists
        //       call customer service to validate customer, insert if legit
        // 2 - create loan entry
        // 3 - return loan application uuid, status, status_reason and timestamps
        return null;
    }

    @GetMapping("/v1/application")
    public ResponseEntity<ApplicationDto> getApplicationByUUID(
            @RequestParam @NotEmpty(message = "uuid cannot be empty") String applicationUUID
    ) {
        // TODO: call service to query and return proper data
        // return application belonging to a specific customer
        return null;
    }

    @GetMapping("/v1/applications")
    public ResponseEntity<GetApplicationsResponse> getApplicationsByApplicantUUID(
            @RequestParam @NotEmpty(message = "uuid cannot be empty") String applicantUUID
    ) {
        // TODO: call service to query and return proper data
        // return all applications belonging to a specific customer
        return null;
    }
}
