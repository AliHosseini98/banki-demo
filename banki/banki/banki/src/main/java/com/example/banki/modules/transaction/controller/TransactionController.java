package com.example.banki.modules.transaction.controller;

import com.example.banki.modules.account.model.Account;
import com.example.banki.modules.account.service.AccountService;
import com.example.banki.modules.transaction.model.Transaction;
import com.example.banki.modules.transaction.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {
    private final TransactionService transactionService;
    private final AccountService accountService;

    public TransactionController(TransactionService transactionService, AccountService accountService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestParam int accId, @RequestParam double amount) {
        Account accSrc = accountService.getById(accId);
        Transaction trs = new Transaction(accSrc, null, amount);
        return ResponseEntity.ok(transactionService.withdraw(transactionService.creatTransaction(trs)));
    }


    @PostMapping("/deposit/{accDestination}/{amount}")
    public ResponseEntity<String> deposit (@PathVariable int accDestination ,@PathVariable double amount ){
        Account accDes = accountService.getById(accDestination);
        Transaction tr = new Transaction(null,accDes ,amount);
        return ResponseEntity.ok(transactionService.deposit(transactionService.creatTransaction(tr)));


    }

    @PostMapping("transfer/{accSource}/{accDestination}/{amount}")
    public ResponseEntity<String> TransferFromAccountToAccount(@PathVariable int accSource,
                                                               @PathVariable double amount,
                                                               @PathVariable int accDestination) {
        Account src = accountService.getById(accSource);
        Account des = accountService.getById(accDestination);
        Transaction tr = new Transaction(src, des, amount);
        return ResponseEntity.ok(transactionService.Card_by_card(tr));
    }




}
