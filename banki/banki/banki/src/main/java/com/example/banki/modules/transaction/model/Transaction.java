package com.example.banki.modules.transaction.model;

import com.example.banki.modules.BaseEntity;
import com.example.banki.modules.account.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
@Data
@NoArgsConstructor
public class Transaction extends BaseEntity {

    @GeneratedValue
    UUID transactionId;
    @ManyToOne
    Account source;

    @ManyToOne
    Account destination;
    double amount;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creationDate;


public Transaction (Account source , Account destination , double amount){
    this.source = source;
    this.destination = destination;
    this.amount = amount;
    this.creationDate = LocalDateTime.now();

}
}




