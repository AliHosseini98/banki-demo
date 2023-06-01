package com.example.banki.modules.account.service;

import com.example.banki.modules.account.model.Account;
import com.example.banki.modules.account.repository.AccountRepository;
import com.example.banki.modules.bankBranch.model.BankBranch;
import com.example.banki.modules.bankBranch.repository.BankBranchRepository;
import com.example.banki.modules.customer.model.Customer;
import com.example.banki.modules.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final BankBranchRepository bankBranchRepository;

    public AccountService(AccountRepository accountRepository, CustomerRepository customerRepository, BankBranchRepository bankBranchRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.bankBranchRepository = bankBranchRepository;
    }


    public Account createAccountForCustomer(int cusId, int bankId) {
        Customer customer = customerRepository.findById(cusId).get();
        BankBranch bankBranch = bankBranchRepository.findById(bankId).get();
        Account account = new Account(customer, bankBranch);
        return accountRepository.save(account);
    }

    public Account getById(int accNum) {
        return accountRepository.findById(accNum).orElseThrow(() -> new RuntimeException("The id entered is not valid"));
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }


//    public List<Account> getAccountsBalance(Long cardId ) {
//        Customer customer = customerRepository.findByCard_id(cardId);
//        return accountRepository.findAccountsByAuthor(customer);
//    }

//    public String getBankStatement (int accId){
//
//
//    }
}
