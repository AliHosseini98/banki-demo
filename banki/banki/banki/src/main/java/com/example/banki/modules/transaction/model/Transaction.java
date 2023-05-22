package com.example.banki.modules.transaction.model;

import com.example.banki.modules.account.model.Account;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Transaction {
    @Id
    @Column(name = "transient_id")
    @GeneratedValue
    private int transactionId;

//    @ManyToOne
//    private Account SourceAccNum ;
//    @ManyToOne
//    private Account DestAccNum;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;


    @ManyToOne(optional = false)
    private Account accounts;

    public Account getAccounts() {
        return accounts;
    }

    public void setAccounts(Account accounts) {
        this.accounts = accounts;
    }
}



/*- Source account number
        - Destination account number
        - Transaction amount
        - Transaction date
        - Transaction type (withdrawal or deposit) */