package com.muazwzxv.accounts.dto.customerDTO;

import com.muazwzxv.accounts.dto.accountDTO.AccountDto;
import lombok.Data;

@Data
public class CustomerDto {
    private String name;
    private String email;
    private String mobileNumber;
    private AccountDto accounts;
}