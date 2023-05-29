package com.example.banki.modules.account.model;

import com.example.banki.modules.BaseEntity;
import com.example.banki.modules.bankBranch.model.BankBranch;
import com.example.banki.modules.customer.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account  {
    @Id
    @Column(name = "account_number")
    @SequenceGenerator(name = "acNum", initialValue = 5000)
    @GeneratedValue(generator = "acNum")
    private int accNumber;

    //creat valid
    private double currentBalance;
    private Date date;
    @ManyToOne
    private Customer customer;

    @ManyToOne
    private BankBranch bankBranch;

    public Account(Customer customer, BankBranch bankBranch) {
        this.currentBalance = 0;
        this.date= getDate();
        this.customer = customer;
        this.bankBranch = bankBranch;
    }

}