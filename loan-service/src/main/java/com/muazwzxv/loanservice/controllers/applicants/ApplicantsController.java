package com.muazwzxv.loanservice.controllers.applicants;

import com.muazwzxv.loanservice.controllers.applicants.payload.UpdateHoldCodeRequest;
import com.muazwzxv.loanservice.controllers.applicants.payload.UpdateHoldCodeResponse;
import com.muazwzxv.loanservice.dto.ResponseDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApplicantsController {

    @GetMapping("/v1/applicant")
    public ResponseEntity<ResponseDto> getApplicantInfo() {
        // TODO: logic to fetch applicant data
        // - validate payload
        // - query the applicant information
        // - transform entity to dto and respond accordingly
        // - addition, query the existing hold code for customer as well
        return null;
    }

    @PutMapping("/v1/applicant/hold-code")
    public ResponseEntity<UpdateHoldCodeResponse> updateHoldCode(
            @RequestBody UpdateHoldCodeRequest updateHoldCodeRequest
    ) {
        // TODO: logic to handle this scenario
        // - validate payload
        // - create table called hold code
        // - check if customer has existing hold code
        // - tag customer with new hold code
        return null;
    }
}
