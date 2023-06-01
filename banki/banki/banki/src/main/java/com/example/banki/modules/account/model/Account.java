package com.example.banki.modules.account.model;

import com.example.banki.modules.BaseEntity;
import com.example.banki.modules.bankBranch.model.BankBranch;
import com.example.banki.modules.customer.model.Customer;
import com.example.banki.modules.transaction.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Account {

    @Id
    @Column(name = "account_number")
    @SequenceGenerator(name = "acNum", initialValue = 5000)
    @GeneratedValue(generator = "acNum")
    private int accNumber;

    //creat valid
    private double currentBalance;



    @OneToMany
    List<Transaction> transactions;

    @ManyToOne
    private Customer author;

    @ManyToOne
    private BankBranch bankBranch;

    public Account(Customer author, BankBranch bankBranch) {
        this.currentBalance = 0;
        this.author = author;
        this.bankBranch = bankBranch;
    }

}