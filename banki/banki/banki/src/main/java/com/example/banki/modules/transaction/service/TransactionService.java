package com.example.banki.modules.transaction.service;

import com.example.banki.modules.account.model.Account;
import com.example.banki.modules.account.repository.AccountRepository;
import com.example.banki.modules.transaction.TransactionConvertor;
import com.example.banki.modules.transaction.TransactionDTO;
import com.example.banki.modules.transaction.model.Transaction;
import com.example.banki.modules.transaction.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final TransactionConvertor transactionConvertor;

    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository, TransactionConvertor transactionConvertor) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.transactionConvertor = transactionConvertor;
    }

    @Transactional
    public String Card_by_card(Transaction transaction) {
        Account src = transaction.getSource();
        Account des = transaction.getDestination();
        if (src.getAuthor().isEnabled() && des.getAuthor().isEnabled()) {
            if (src.getCurrentBalance() > transaction.getAmount()) {
                double deductionSrc = src.getCurrentBalance() - transaction.getAmount();
                accountRepository.save(src);
                src.setCurrentBalance(deductionSrc);
                double addAccount = des.getCurrentBalance() + transaction.getAmount();
                des.setCurrentBalance(addAccount);
                accountRepository.save(des);
                //need to save transaction?
                DecimalFormat df = new DecimalFormat("#,###.###");
                String formattedBalance = df.format(src.getCurrentBalance());
                return "The transaction was completed successfully" + "\n"
                        + "Transaction tracking code: " + transaction.getTransactionId() + "\n"
                        + "Destination account number :" + (des.getAccNumber()) + "\n"
                        + "Source account number :" + (src.getAccNumber()) + "\n"
                        + "Your current balance: " +(formattedBalance)+ "\n"
                        + "Date :" + transaction.getCreationDate();
            }
        }
        return "Sorry, error in operation";
    }

    public Transaction creatTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }


    public String deposit(Transaction transaction) {
        Account des = transaction.getDestination();
        if (des.getAuthor().isEnabled()) {
            des.setCurrentBalance(des.getCurrentBalance() + transaction.getAmount());
            accountRepository.save(des);
            return "The deposit transaction was completed successfully" + "\n"
                    + "Transaction tracking code: " + transaction.getTransactionId() + "\n"
                    + "The amount of " + transaction.getAmount() + "\n"
                    + "transferred to the account of : " + (des.getAccNumber()) + "." + "\n"
                    + "Date :" + transaction.getCreationDate();
        }return "It is not possible to deposit";
    }

        public String withdraw (Transaction transaction){
        Account source = transaction.getSource();
            if (source.getAuthor().isEnabled()) {
                source.setCurrentBalance(source.getCurrentBalance() - transaction.getAmount());
                accountRepository.save(source);

                return "The withdraw transaction was completed successfully" + "\n"
                        + "Transaction tracking code: " + transaction.getTransactionId() + "\n"
                        + "The amount of " + transaction.getAmount() + "\n"
                        + "transferred to the account of : " + (source.getAccNumber()) + "." + "\n"
                        + "Date :" + transaction.getCreationDate();
            }return "It is not possible to withdraw";
        }


        public List<TransactionDTO> getTransactions(){

        return transactionConvertor.transactionDTOList(transactionRepository.findAll());
        }

//        public List<TransactionDTO> getTransactionByAccountId(int id){
//
//        }

}
