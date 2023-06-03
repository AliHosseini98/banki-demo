package com.example.banki.modules.transaction.repository;

import com.example.banki.modules.transaction.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
@Query("select a from  Transaction a where a.source.author.card_id= ?1 order by a.creationDate" )
    List<Transaction> findAllSourceByCardId(Long cardId);

    @Query("select a from  Transaction a where a.destination.author.card_id= ?1  order by a.creationDate" )
    List<Transaction> findAllDestinationByCardId(Long cardId);

    Transaction findByTransactionId(UUID uuid);
}
