package com.example.banki.modules.account.repository;

import com.example.banki.modules.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {

}
