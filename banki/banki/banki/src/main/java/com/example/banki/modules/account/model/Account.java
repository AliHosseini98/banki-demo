package com.example.banki.modules.account.model;

import com.example.banki.modules.bankBranch.model.BankBranch;
import com.example.banki.modules.customer.model.Customer;
import com.example.banki.modules.transaction.model.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Account {
    @Id
    @Column(name = "account_number")
    @SequenceGenerator(name = "acNum", initialValue = 1000)
    @GeneratedValue(generator = "acNum")
    private int accNumber;
    private double currentBalance;
    private Date date;
    @ManyToOne
    private Customer customer;

    @ManyToOne
    private BankBranch bankBranch;

    protected Account() {

    }

    public Account(Customer customer, BankBranch bankBranch) {
        currentBalance = 0;
        date = new Date();
        this.customer = customer;
        this.bankBranch = bankBranch;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accNumber=" + accNumber +
                ", currentBalance=" + currentBalance +
                ", date=" + date +
                ", customer=" + customer +
                ", bankBranch=" + bankBranch +
                '}';
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BankBranch getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(BankBranch bankBranch) {
        this.bankBranch = bankBranch;
    }
}
