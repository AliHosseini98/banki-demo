package com.example.banki.modules.transaction.model;

import com.example.banki.modules.BaseEntity;
import com.example.banki.modules.account.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class Transaction extends BaseEntity {

    UUID transactionId = UUID.randomUUID();
    @ManyToOne
    @JoinTable(name = "transaction_account_source")
    @JoinColumn(name = "account_id", referencedColumnName = "account_number")
    Account source;

    @ManyToOne
    @JoinTable(name = "transaction_account_destination")
    @JoinColumn(name = "account_id", referencedColumnName = "account_number")
    Account destination;
    double amount;


    public Transaction(Account source, Account destination, double amount) {
        this.source = source;
        this.destination = destination;
        this.amount = amount;
    }

}




