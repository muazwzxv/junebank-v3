package com.muazwzxv.accounts.controllers;

import com.muazwzxv.accounts.constants.AccountsConstants;
import com.muazwzxv.accounts.dto.ResponseDto;
import com.muazwzxv.accounts.dto.accountDTO.UpdateAccountDto;
import com.muazwzxv.accounts.dto.customerDTO.CreateCustomerDto;
import com.muazwzxv.accounts.dto.customerDTO.CustomerDto;
import com.muazwzxv.accounts.service.IAccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AccountsController {

    private IAccountService accountService;

    @PostMapping("/v1/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CreateCustomerDto customerDto) {
        this.accountService.createAccount(customerDto);
        return ResponseEntity.
                status(HttpStatus.CREATED).
                body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @GetMapping("/v1/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(
            @RequestParam @NotEmpty(message = "mobile number cannot be empty") String mobileNumber
    ) {
        CustomerDto customerDto = this.accountService.fetchAccount(mobileNumber);
        return ResponseEntity.
                status(HttpStatus.OK).
                body(customerDto);
    }

    @PutMapping("/v1/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto req) {
        boolean isUpdated = this.accountService.updateAccount(req);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        }

        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                .body(new ResponseDto(AccountsConstants.STATUS_412, AccountsConstants.MESSAGE_NO_ACCOUNT_UPDATE));
    }

    @PutMapping("/v2/update")
    public ResponseEntity<CustomerDto> updateAccountV2(@Valid @RequestBody UpdateAccountDto req) {
        CustomerDto customerDto = this.accountService.updateAccountV2(req);
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerDto);
    }

    @DeleteMapping("/v2/delete")
    public ResponseEntity<ResponseDto> deleteAccount(
            @RequestParam @NotEmpty(message = "account number cannot be empty") Long accountNumber
    ) {
        this.accountService.deleteAccount(accountNumber);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).
                body(null);
    }
}
