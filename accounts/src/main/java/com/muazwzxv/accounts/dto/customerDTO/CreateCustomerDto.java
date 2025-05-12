package com.muazwzxv.accounts.dto.customerDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateCustomerDto {
    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 5, max = 50, message = "The length of the customer name should be between 5 and 30")
    private String name;

    @NotEmpty(message = "Email address can not be null or empty")
    @Email(message = "Email needs to be valid")
    private String email;

    @NotEmpty(message = "Mobile number can not be null or empty")
    private String mobileNumber;
}
