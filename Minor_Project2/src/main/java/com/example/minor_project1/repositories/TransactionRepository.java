package com.example.minor_project1.repositories;

import com.example.minor_project1.models.Book;
import com.example.minor_project1.models.Student;
import com.example.minor_project1.models.Transaction;
import com.example.minor_project1.models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    // select t from Transaction t where t.book.id = ?1 and t.student.id = ?1 and t.transactionType = ISSUE
    // and t.transactionStatus = SUCCESS order by id desc limit 1


    /**
     * S1    -->  issue  -->      B1        T1     Success
     * S1    -->  return -->     B1        T2     Success
     * S1    -->  issue  -->     B1        T5     Failed
     * S1    -->  issue   -->     B1        T3    Success
     * S1    -->  ISSUE   -->     B1        T6    Can this be possible ?  Possible if consider a case of concurrency
     *
     * -----
     * S1    -->  return  -->    B1        T4
     *
     *
     * // [T3 , T1]
     * // transactionList.get(0)
     */

    Transaction findTopByStudentAndBookAndTransactionTypeOrderByIdDesc(Student student, Book book, TransactionType transactionType);
}

