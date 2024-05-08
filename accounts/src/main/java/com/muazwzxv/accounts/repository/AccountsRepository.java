package com.muazwzxv.accounts.repository;

import com.muazwzxv.accounts.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Account, Long> {

}
