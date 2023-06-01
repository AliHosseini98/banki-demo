package com.example.banki.modules.transaction.model;

import com.example.banki.modules.BaseEntity;
import com.example.banki.modules.account.model.Account;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table
public class Transaction extends BaseEntity {

    UUID transactionId=UUID.randomUUID();
    @ManyToOne
    Account source;

    @ManyToOne
    Account destination;
    double amount;
    public Transaction() {
    }

    public Transaction(Account source, Account destination, double amount) {

        this.source = source;
        this.destination = destination;
        this.amount = amount;
    }

}




