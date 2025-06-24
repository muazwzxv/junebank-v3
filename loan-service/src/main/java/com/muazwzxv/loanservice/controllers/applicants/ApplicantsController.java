package com.muazwzxv.loanservice.controllers.applicants;

import com.muazwzxv.loanservice.controllers.applicants.Http.UpdateHoldCodeReqHttp;
import com.muazwzxv.loanservice.controllers.applicants.Http.UpdateHoldCodeRespHttp;
import com.muazwzxv.loanservice.dto.ApplicantDto;
import com.muazwzxv.loanservice.services.applicant.IApplicantService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApplicantsController {

    private IApplicantService applicantService;

    @GetMapping("/v1/applicant")
    public ResponseEntity<ApplicantDto> getApplicantInfo(
            @RequestParam @NotEmpty(message = "uuid cannot be empty") String applicantUUID
    ) {
        ApplicantDto applicantDto = this.applicantService.getApplicantByUUID(applicantUUID);
        // TODO: addition, query the existing hold code for customer as well

        return ResponseEntity.ok(applicantDto);
    }

    @PutMapping("/v1/applicant/hold-code")
    public ResponseEntity<UpdateHoldCodeReqHttp> updateHoldCode(
            @RequestBody UpdateHoldCodeRespHttp updateHoldCodeRequest
    ) {
        // TODO: logic to handle this scenario
        // - validate payload
        // - create table called hold code
        // - check if customer has existing hold code
        // - tag customer with new hold code
        return null;
    }
}
