package com.example.banki.modules.account;

import com.example.banki.modules.bankBranch.model.BankBranch;
import com.example.banki.modules.customer.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class AccountDTO {

    private int accNumber;
    private double currentBalance;
    private Date date;
    private String customer;
    private String bankBranch;

}
