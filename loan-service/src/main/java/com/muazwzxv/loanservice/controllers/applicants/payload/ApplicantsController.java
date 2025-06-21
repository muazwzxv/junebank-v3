package com.muazwzxv.loanservice.controllers.applicants.payload;

import com.muazwzxv.loanservice.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApplicantsController {

    @GetMapping("/v1/applicant")
    public ResponseEntity<ResponseDto> getApplicant() {
        return null;
    }
}
