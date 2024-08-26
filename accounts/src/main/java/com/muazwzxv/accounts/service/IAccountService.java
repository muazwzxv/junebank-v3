package com.muazwzxv.accounts.service;

import com.muazwzxv.accounts.dto.CustomerDto;

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
}
