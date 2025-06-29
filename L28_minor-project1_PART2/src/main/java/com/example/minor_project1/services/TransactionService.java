package com.example.minor_project1.services;

import com.example.minor_project1.models.*;
import com.example.minor_project1.repositories.TransactionRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Value("${books.issue.max-allowed}")
    Integer maxAllowedBooks;

    @Autowired
    private BookService bookService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TransactionRepository transactionRepository;

    public String issueTxn(Integer studentId, Integer bookId){

        /**
         * 1. book id should be valid and is available
         * 2. student id should be valid number of books available to that student should be less than maxAllowed
         *
         */

        Book book = bookService.findById(bookId);
        // Note: is_available column and field in java class can be skipped. we can always figure out whether a book is available or not by checking the student_id column
//        if(book != null && book.getAvailable()){
//
//        }

        if(book == null || book.getStudent() != null){
            throw new ValidationException("book is not available to issue");
        }

        Student student = this.studentService.findById(studentId);
        if(student == null){
            throw new ValidationException("student id is invalid");
        }

        List<Book> bookList = this.bookService.findBooksIssued(studentId);

        if(bookList == null || bookList.size() >= maxAllowedBooks){
            throw new ValidationException("student has issued more books than max allowed");
        }

        Transaction transaction = new Transaction();
        transaction.setTransactionType(TransactionType.ISSUE);
        transaction.setTransactionStatus(TransactionStatus.PENDING);
        transaction.setExternalTxnId(UUID.randomUUID().toString());
        transaction.setBook(book);
        transaction.setStudent(student);

        transaction = this.transactionRepository.save(transaction); // getting the transaction object because it has the id coming from underlying db

        try {
            book.setAvailable(false);
            book.setStudent(student);
            this.bookService.create(book);
            transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        }catch (Exception e){
            book.setStudent(null);
            book.setAvailable(true);
            bookService.create(book);
            transaction.setTransactionStatus(TransactionStatus.FAILED);

        }finally {
            this.transactionRepository.save(transaction); // if this fails --- edge case's edge case
        }

        return transaction.getExternalTxnId();
    }
}
