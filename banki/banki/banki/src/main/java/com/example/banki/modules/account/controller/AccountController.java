package com.example.banki.modules.account.controller;

import com.example.banki.modules.account.model.AccountDTO;
import com.example.banki.modules.account.service.AccountService;
import com.example.banki.modules.transaction.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {
    private final AccountService accountService;
    private final TransactionService transactionService;

    public AccountController(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @PostMapping("/register/{customerId}/{bankId}")
    public ResponseEntity<AccountDTO> registerAccount(@PathVariable int customerId, @PathVariable int bankId) {
        return ResponseEntity.ok(accountService.createAccountForCustomer(customerId, bankId));
    }

    @GetMapping("/get/accounts")
    public List<AccountDTO> getAllAccounts() {

        return accountService.getAllAccounts();
    }





}
