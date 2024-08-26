package com.muazwzxv.accounts.service.impl;

import com.muazwzxv.accounts.constants.AccountsConstants;
import com.muazwzxv.accounts.dto.CustomerDto;
import com.muazwzxv.accounts.entities.Accounts;
import com.muazwzxv.accounts.entities.Customer;
import com.muazwzxv.accounts.exception.CustomerAlreadyExistsException;
import com.muazwzxv.accounts.mapper.CustomerMapper;
import com.muazwzxv.accounts.repository.AccountsRepository;
import com.muazwzxv.accounts.repository.CustomersRepository;
import com.muazwzxv.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
    private AccountsRepository accountsRepository;
    private CustomersRepository customersRepository;


    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(new Customer(), customerDto);
        Optional<Customer> existingCustomer = this.customersRepository.findByMobileNumber(customer.getMobileNumber());

        if (existingCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("customer registered with number " + customer.getMobileNumber());
        }

        customer.setCreatedBy("CLIENT");
        customer.setCreatedAt(LocalDateTime.now());

        Customer savedCustomer = this.customersRepository.save(customer);
        Accounts newCustomerSavingAccounts = this.createNewAccount(savedCustomer);

        this.accountsRepository.save(newCustomerSavingAccounts);
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();

        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 10000000L + new Random().nextInt(9000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedBy("CLIENT");
        newAccount.setCreatedAt(LocalDateTime.now());

        return newAccount;
    }
}
