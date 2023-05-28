package com.example.banki.modules.account.model;

import com.example.banki.modules.bankBranch.model.BankBranch;
import com.example.banki.modules.customer.model.Customer;
import com.example.banki.modules.transaction.model.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Account {
    @Id
    @Column(name = "account_number")
    @SequenceGenerator(name = "acNum", initialValue = 1000)
    @GeneratedValue(generator = "acNum")
    private int accNumber;

    //creat valid
    private double currentBalance;
    private Date date;
    @ManyToOne
    private Customer customer;

    @ManyToOne
    private BankBranch bankBranch;
}