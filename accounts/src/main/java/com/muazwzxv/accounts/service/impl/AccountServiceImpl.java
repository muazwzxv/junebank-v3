package com.muazwzxv.accounts.service.impl;

import com.muazwzxv.accounts.dto.CustomerDto;
import com.muazwzxv.accounts.repository.AccountsRepository;
import com.muazwzxv.accounts.repository.CustomersRepository;
import com.muazwzxv.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountsRepository accountsRepository;
    private CustomersRepository customersRepository;


    @Override
    public void createAccount(CustomerDto customerDto) {

    }
}
