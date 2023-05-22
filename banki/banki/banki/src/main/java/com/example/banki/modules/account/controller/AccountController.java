package com.example.banki.modules.account.controller;

import com.example.banki.modules.account.model.Account;
import com.example.banki.modules.account.service.AccountService;
import com.example.banki.modules.customer.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/register/{customerId}/{bankId}")
    @ResponseBody
    public ResponseEntity<Account> registerAccount(@PathVariable int customerId, @PathVariable int bankId) {
        return ResponseEntity.ok(accountService.createAccountForCustomer(customerId, bankId));
    }


    @PostMapping("/deposit/{accId}/{amount}")
    @ResponseBody
    public ResponseEntity<Account> depositToAccount(@PathVariable int accId,@PathVariable double amount) {
        return ResponseEntity.ok(accountService.depositToAccount(accId, amount));
    }

    @PostMapping("transfer/{accSource}/{amount}/{accDestination}")
    public ResponseEntity<Customer> transferToTheAccount (@PathVariable int accSource,@PathVariable double amount , @PathVariable int accDestination ){
        return ResponseEntity.ok(accountService.transferToTheAccount(accSource,amount,accDestination));
    }

    @GetMapping("/get/accounts")
    @ResponseBody
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @PostMapping("/false/{cusId}")
    @ResponseBody
    public void accountBlocked(@PathVariable int cusId){
        accountService.accountBlocked(cusId);
    }
    @PostMapping("/true/{cusId}")
    @ResponseBody
    public void accountUnblocked(@PathVariable int cusId){
        accountService.unblockAccount(cusId);
    }

    @GetMapping("/balance/{accId}")
    @ResponseBody
    public String getBalance(@PathVariable int accId){
        return accountService.getAccountBalance(accId);
    }

}
