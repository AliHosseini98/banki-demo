package com.example.banki.modules.account.model;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountConvertor {

    public AccountDTO entityToDto(Account account){
        AccountDTO dto = new AccountDTO();
        dto.setAccNumber(account.getAccNumber());

        dto.setCurrentBalance(account.getCurrentBalance());
        String customer = "full name: " + account.getAuthor().getName() +" "+ account.getAuthor().getFamily() + "  -  "
                +"card id: " + account.getAuthor().getCard_id();
        dto.setAuthor(customer);

        String bank = "branch: "  + account.getBankBranch().getName() +"  -  "+"code: " + account.getBankBranch().getId() +"  -  "
                +"address: "+ account.getBankBranch().getAddress();
        dto.setBankBranch(bank);
        dto.setDateTime(account.getCreationDate());
        return dto;

    }

    public List<AccountDTO> dtoList (List<Account> accountList){
        return accountList.stream().map(account -> entityToDto(account)).collect(Collectors.toList());

    }
}
