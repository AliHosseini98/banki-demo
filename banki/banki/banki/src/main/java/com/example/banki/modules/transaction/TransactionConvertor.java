package com.example.banki.modules.transaction;
import com.example.banki.modules.account.model.Account;
import com.example.banki.modules.transaction.model.Transaction;
import org.springframework.stereotype.Component;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class TransactionConvertor {


    public TransactionDTO entityToDto(Transaction transaction) {
        TransactionDTO dto = new TransactionDTO();

//        dto.setType(checkType(transaction.getSource(),transaction.getDestination()));
        dto.setTransactionId(transaction.getTransactionId());
        dto.setCreationDate(transaction.getCreationDate());
        dto.setSource(checkNull(transaction.getSource()));
        dto.setDestination(checkNull(transaction.getDestination()));
        double number = transaction.getAmount();
        DecimalFormat dcFormat = new DecimalFormat("#,###.###");
        String formattedNumber = dcFormat.format(number);
        dto.setAmount(formattedNumber);
        return dto;
    }

    public List<TransactionDTO> transactionDTOList(List<Transaction> transactionList) {
        return transactionList.stream().map(transaction -> entityToDto(transaction)).collect(Collectors.toList());
    }

    private String checkNull(Account account) {
        if (account == null) {
            return "Bank";
        } else {
            return
                    "account number : " + "'" + account.getAccNumber() + "'" + "-" + " full name : " + account.getAuthor().getName() + "  " + account.getAuthor().getFamily();
        }
    }



}
