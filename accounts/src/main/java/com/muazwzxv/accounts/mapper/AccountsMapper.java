package com.muazwzxv.accounts.mapper;

import com.muazwzxv.accounts.dto.AccountDto;
import com.muazwzxv.accounts.entities.Accounts;

public class AccountsMapper {
    public static AccountDto mapToAccountsDto(Accounts accounts, AccountDto accountDto) {
        accountDto.setAccountNumber(accounts.getAccountNumber());
        accountDto.setAccountType(accounts.getAccountType());
        accountDto.setBranchAddress(accounts.getBranchAddress());

        return accountDto;
    }

    public static Accounts mapToAccounts(Accounts accounts, AccountDto accountDto) {
        accounts.setAccountNumber(accountDto.getAccountNumber());
        accounts.setAccountType(accountDto.getAccountType());
        accounts.setBranchAddress(accountDto.getBranchAddress());

        return accounts;
    }
}
