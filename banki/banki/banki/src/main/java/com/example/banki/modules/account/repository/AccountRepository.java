package com.example.banki.modules.account.repository;

import com.example.banki.modules.account.model.Account;
import com.example.banki.modules.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
