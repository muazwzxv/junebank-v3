package com.muazwzxv.accounts.dto.customerDTO;

import com.muazwzxv.accounts.dto.accountDTO.AccountDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {
    @NotEmpty(message = "name cannot be null or empty")
    @Size(min = 5, max = 30, message = "length should be between 5 and 30")
    private String name;

    @NotEmpty(message = "email cannot be null or empty")
    @Email(message = "not a valid email")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "mobile number must be 10 digits")
    private String mobileNumber;

    private AccountDto accounts;
}