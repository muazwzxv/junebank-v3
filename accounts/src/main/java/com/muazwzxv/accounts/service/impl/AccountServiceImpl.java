package com.muazwzxv.accounts.service.impl;

import com.muazwzxv.accounts.constants.AccountsConstants;
import com.muazwzxv.accounts.dto.accountDTO.AccountDto;
import com.muazwzxv.accounts.dto.accountDTO.UpdateAccountDto;
import com.muazwzxv.accounts.dto.customerDTO.CustomerDto;
import com.muazwzxv.accounts.entities.Accounts;
import com.muazwzxv.accounts.entities.Customer;
import com.muazwzxv.accounts.exception.ResourceNotFoundException;
import com.muazwzxv.accounts.exception.UnexpectedErrorException;
import com.muazwzxv.accounts.exception.accountException.AccountOperationException;
import com.muazwzxv.accounts.exception.accountException.NoAccountForUpdateException;
import com.muazwzxv.accounts.exception.customerException.CustomerAlreadyExistsException;
import com.muazwzxv.accounts.mapper.AccountsMapper;
import com.muazwzxv.accounts.mapper.CustomerMapper;
import com.muazwzxv.accounts.repository.AccountsRepository;
import com.muazwzxv.accounts.repository.CustomersRepository;
import com.muazwzxv.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.QueryTimeoutException;
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

    @Override
    public CustomerDto fetchAccount(String phoneNumber) {
        log.debug("starting fetch account flow");

        Customer customer = this.customersRepository.findByMobileNumber(phoneNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", phoneNumber)
        );
        Accounts account = this.accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", phoneNumber)
        );

        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccounts(AccountsMapper.mapToAccountsDto(account, new AccountDto()));


        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        AccountDto customersAccount = customerDto.getAccounts();
        if (customersAccount == null) {
            log.warn("Customer: {}, does not have an account", customerDto.getMobileNumber());
            return false;
        }

        // fetch the account
        Accounts account = accountsRepository.findById(customersAccount.getAccountNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "AccountNumber", customersAccount.getAccountNumber().toString())
        );

        AccountsMapper.mapToAccounts(account, customersAccount);
        account = accountsRepository.save(account);

        Long customerID = account.getCustomerId();
        Customer customer = customersRepository.findById(customerID).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "CustomerID", customerID.toString())
        );
        CustomerMapper.mapToCustomer(customer, customerDto);
        customersRepository.save(customer);

        return true;
    }

    @Override
    public CustomerDto updateAccountV2(UpdateAccountDto req) {
        Customer customerEntity = customersRepository.findByMobileNumber(req.getMobileNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "MobileNumber", req.getMobileNumber().toString())
        );

        Accounts accountEntity = accountsRepository.findByCustomerId(customerEntity.getCustomerId()).orElseThrow(
                () -> new NoAccountForUpdateException(customerEntity.getMobileNumber())
        );

        // update allowed for these
        accountEntity.setBranchAddress(req.getBranchAddress());
        accountEntity.setAccountType(req.getAccountType());

        accountsRepository.save(accountEntity);

        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customerEntity, new CustomerDto());
        AccountDto accountDto = AccountsMapper.mapToAccountsDto(accountEntity, new AccountDto());

        customerDto.setAccounts(accountDto);

        return customerDto;
    }

    @Override
    public void deleteAccount(String accountNumber) {
        try {
            Accounts accountEntity = this.accountsRepository.findByAccountNumber(accountNumber).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "accountNumber", accountNumber)
            );
            this.accountsRepository.delete(accountEntity);
        } catch (QueryTimeoutException ex) {
            log.error("query timeout err: {}", ex.getMessage());
            throw new AccountOperationException("timeout occurred while attempting to delete account: " + accountNumber, ex);
        } catch (ResourceNotFoundException ex) {
            log.warn("Account not found: {}", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            log.error("unexpected error when deleting account: {}", ex.getMessage());
            throw new UnexpectedErrorException("unexpected error when deleting account: {}" + ex.getMessage(), ex);
        }
    }
}