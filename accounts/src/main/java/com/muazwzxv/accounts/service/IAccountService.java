package com.muazwzxv.accounts.service;

import com.muazwzxv.accounts.dto.accountDTO.UpdateAccountDto;
import com.muazwzxv.accounts.dto.customerDTO.CustomerDto;

public interface IAccountService {

    /**
     * @param customerDto - CustomerDTO Object
     */
    void createAccount(CustomerDto customerDto);

    /**
     * @param phoneNumber
     * @return
     */
    CustomerDto fetchAccount(String phoneNumber);

    boolean updateAccount(CustomerDto customerDto);

    CustomerDto updateAccountV2(UpdateAccountDto req);

    void deleteAccount(Long accountNumber);
}
