package com.example.banki.modules.account;

import com.example.banki.modules.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountConvertor {
    public AccountDTO entityToDto(Account account) {
        AccountDTO dto = new AccountDTO();
        dto.setAccNumber(account.getAccNumber());
        dto.setCurrentBalance(account.getCurrentBalance());
        dto.setDate(account.getDate());
        dto.setCustomer(String.valueOf(account.getCustomer().getId() + "\n"
                + account.getCustomer().getName() + "\n"
                + account.getCustomer().getFamily()));
        dto.setBankBranch(String.valueOf("branch code is : " + account.getBankBranch().getId() + "\n"
                + "bank name is : " + account.getBankBranch().getName()));
        return dto;
    }

    public List<AccountDTO> accountDTOList(List<Account> accountList) {
        return accountList.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }
}
