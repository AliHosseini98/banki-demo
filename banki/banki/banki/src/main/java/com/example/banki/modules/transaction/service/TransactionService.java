package com.example.banki.modules.transaction.service;

import com.example.banki.modules.account.model.Account;
import com.example.banki.modules.account.repository.AccountRepository;
import com.example.banki.modules.transaction.model.Transaction;
import com.example.banki.modules.transaction.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public String Card_by_card(Transaction transaction) {
        Account src = transaction.getSource();
        Account des = transaction.getDestination();
        if (src.getAuthor().isEnabled() && des.getAuthor().isEnabled() == true) {
            if (src.getCurrentBalance() > transaction.getAmount()) {
                double deductionSrc = src.getCurrentBalance() - transaction.getAmount();
                accountRepository.save(src);
                src.setCurrentBalance(deductionSrc);
                double addAccount = des.getCurrentBalance() + transaction.getAmount();
                des.setCurrentBalance(addAccount);
                accountRepository.save(des);
                transactionRepository.save(transaction);
                String result = "The transaction was completed successfully" + "\n"
                        + "Transaction tracking code: " + transaction.getTransactionId() + "\n"
                        + "Destination account number :" + String.valueOf(des.getAccNumber()) + "\n"
                        + "Source account number :" + String.valueOf(src.getAccNumber()) + "\n"
                        + "Your current balance: " + String.valueOf(src.getCurrentBalance());
                return result;
            }
        }
        return "Sorry, error in operation";
    }

    public Transaction creatTransaction(int accIdSrc , int accIdDes , double amount ){
        Account src = accountRepository.findById(accIdSrc).get();
        Account des = accountRepository.findById(accIdDes).get();

        Transaction transaction = new Transaction(src,des,amount);
        return transaction;
    }

}
