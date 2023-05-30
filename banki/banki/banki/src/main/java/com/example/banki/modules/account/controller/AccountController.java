package com.example.banki.modules.account.controller;

import com.example.banki.modules.account.model.Account;
import com.example.banki.modules.account.service.AccountService;
import com.example.banki.modules.transaction.model.Transaction;
import com.example.banki.modules.transaction.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;
    private final TransactionService transactionService;

    public AccountController(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @PostMapping("/register/{customerId}/{bankId}")
    @ResponseBody
    public ResponseEntity<Account> registerAccount(@PathVariable int customerId, @PathVariable int bankId) {
        return ResponseEntity.ok(accountService.createAccountForCustomer(customerId, bankId));
    }

//account/deposit/{accId}/{amount}
    @PostMapping("/deposit/{accId}/{amount}")
    @ResponseBody
    public ResponseEntity<Account> depositToAccount(@PathVariable int accId,@PathVariable double amount) {
        return ResponseEntity.ok(accountService.depositToAccount1(accId, amount));
    }

//    @PostMapping("transfer/{accSource}/{amount}/{accDestination}")
//    public ResponseEntity<Customer> transferToTheAccount (@PathVariable int accSource,@PathVariable double amount , @PathVariable int accDestination ){
//        return ResponseEntity.ok(accountService.transferToTheAccount(accSource,amount,accDestination));
//    }

    @PostMapping("transfer/{accSource}/{amount}/{accDestination}")
    @ResponseBody
    public ResponseEntity<String> transferToTheAccount (@PathVariable int accSource,@PathVariable double amount , @PathVariable int accDestination ){

       Transaction tr =  transactionService.creatTransaction(accSource,accDestination,amount);
        return ResponseEntity.ok(transactionService.Card_by_card(tr));
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
