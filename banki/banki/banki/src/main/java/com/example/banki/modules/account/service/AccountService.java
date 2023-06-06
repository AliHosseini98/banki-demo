package com.example.banki.modules.account.service;


import com.example.banki.modules.account.model.Account;
import com.example.banki.modules.account.model.AccountConvertor;
import com.example.banki.modules.account.model.AccountDTO;
import com.example.banki.modules.account.repository.AccountRepository;
import com.example.banki.modules.bankBranch.model.BankBranch;
import com.example.banki.modules.bankBranch.repository.BankBranchRepository;
import com.example.banki.modules.customer.model.Customer;
import com.example.banki.modules.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final BankBranchRepository bankBranchRepository;
    private final AccountConvertor accountConvertor;

    public AccountService(AccountRepository accountRepository, CustomerRepository customerRepository, BankBranchRepository bankBranchRepository, AccountConvertor accountConvertor) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.bankBranchRepository = bankBranchRepository;
        this.accountConvertor = accountConvertor;
    }


    public AccountDTO createAccountForCustomer(int cusId, int bankId) {
        Customer customer = customerRepository.findById(cusId).get();
        BankBranch bankBranch = bankBranchRepository.findById(bankId).get();
        Account account = new Account(customer, bankBranch);
        return accountConvertor.entityToDto(accountRepository.save(account));
    }

    public Account getById(int accNum) {
        return accountRepository.findById(accNum).orElseThrow(() -> new RuntimeException("The id entered is not valid"));
    }

    public List<AccountDTO> getAllAccounts() {
        return accountConvertor.dtoList(accountRepository.findAll());
    }


}
