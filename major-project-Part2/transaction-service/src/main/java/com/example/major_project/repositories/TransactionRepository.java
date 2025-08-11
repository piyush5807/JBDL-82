package com.example.major_project.repositories;

import com.example.major_project.model.Transaction;
import com.example.major_project.model.TransactionStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Modifying
    @Transactional
    @Query("update Transaction t set t.status = ?2 where t.externalTransactionId = ?1")
    void updateTransaction(String externalTransactionId, TransactionStatus status);
}
