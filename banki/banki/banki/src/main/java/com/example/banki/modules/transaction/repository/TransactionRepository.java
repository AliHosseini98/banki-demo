package com.example.banki.modules.transaction.repository;

import com.example.banki.modules.transaction.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
