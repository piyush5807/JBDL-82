package com.example.minor_project1.services;

import com.example.minor_project1.models.*;
import com.example.minor_project1.repositories.TransactionRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Value("${books.issue.max-allowed}")
    Integer maxAllowedBooks;

    @Value("${books.issue.duration}")
    Integer issuanceDaysThreshold;

    @Value("${books.fine.per-day}")
    Integer finePerDay;

    @Autowired
    private BookService bookService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TransactionRepository transactionRepository;

    public String issueTxnUtil(Integer studentId, Integer bookId, Integer maxAllowedBooks){

        Book book = bookService.findById(bookId);
        // Note: is_available column and field in java class can be skipped. we can always figure out whether a book is available or not by checking the student_id column
//        if(book != null && book.getAvailable()){
//
//        }
        if(book == null || book.getStudent() != null){
            throw new ValidationException("book is not available to issue");
        }
        Long originalIssueCount = book.getIssueCount() == null ? 0 : book.getIssueCount();

        Student student = this.studentService.findById(studentId);
        if(student == null){
            throw new ValidationException("student id is invalid");
        }

        List<Book> bookList = this.bookService.findBooksIssued(studentId);

        // Check if the re-issuance is allowed in a certain time window
        Transaction lastReturnTxn = transactionRepository.findTopByStudentAndBookAndTransactionTypeOrderByIdDesc(student, book, TransactionType.RETURN);
//        if(ChronoUnit.DAYS.between(lastReturnTxn.getCreatedAt().toInstant(), new Date().toInstant()) < 7){
//            throw new ValidationException("reissuance cannot be done within a week");
//        }

        if(bookList == null || bookList.size() >= maxAllowedBooks){
            throw new ValidationException("student has issued more books than max allowed");
        }

        Transaction transaction = new Transaction();     // t1
        transaction.setTransactionType(TransactionType.ISSUE);
        transaction.setTransactionStatus(TransactionStatus.PENDING);
        transaction.setExternalTxnId(UUID.randomUUID().toString());
        transaction.setBook(book);
        transaction.setStudent(student);

        // Add this entry in some audit table
//        transactionAuditRepository.save(transaction);

        transaction = this.transactionRepository.save(transaction); // getting the transaction object because it has the id coming from underlying db

        try {
            book.setAvailable(false);
            book.setStudent(student);
            book.setIssueCount(originalIssueCount + 1);
            this.bookService.create(book);
            transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        }catch (Exception e){
            book.setStudent(null);
            book.setAvailable(true);
            book.setIssueCount(originalIssueCount);
            bookService.create(book);
            transaction.setTransactionStatus(TransactionStatus.FAILED);

        }finally {
            this.transactionRepository.save(transaction); // if this fails --- edge case's edge case
        }

        return transaction.getExternalTxnId();
    }

    public String issueTxn(Integer studentId, Integer bookId){

        return issueTxnUtil(studentId, bookId, maxAllowedBooks);
        /**
         * 1. book id should be valid and is available
         * 2. student id should be valid number of books available to that student should be less than maxAllowed
         *
         */
    }

    public String returnTxn(Integer studentId, Integer bookId) {

        // book.studentId != null => it only checks whether the book is assigned to some student
        // book.studentId == studentId => it checks whether the book is assigned and that to the student with id studentId

        Book book = this.bookService.findById(bookId);
        if(book == null || book.getStudent() == null || book.getStudent().getId() != studentId){
            throw new ValidationException("book is not assigned to the relevant student");
        }

        Student student = this.studentService.findById(studentId);

        Transaction transaction = new Transaction();
        transaction.setExternalTxnId(UUID.randomUUID().toString());
        transaction.setTransactionStatus(TransactionStatus.PENDING);
        transaction.setTransactionType(TransactionType.RETURN);
        transaction.setBook(book);
        transaction.setStudent(student);
        transaction.setFine(calculateFine(book, student));

        transaction = transactionRepository.save(transaction);

        try {
            book.setAvailable(true);
            book.setStudent(null);
            bookService.create(book); // update book with availability as true and student as null since book object has an id so it will be merged not persisted
            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        }catch (Exception e){
            book.setStudent(student);
            book.setAvailable(false);
            bookService.create(book);
            transaction.setTransactionStatus(TransactionStatus.FAILED);
        }finally {
            transactionRepository.save(transaction);
        }

        return transaction.getExternalTxnId();
    }

    public Long calculateFine(Book book, Student student){

        Transaction transaction = transactionRepository.findTopByStudentAndBookAndTransactionTypeOrderByIdDesc(student, book, TransactionType.ISSUE);

        long daysPassed = ChronoUnit.DAYS.between(transaction.getCreatedAt().toInstant(), new Date().toInstant());

        if((daysPassed - issuanceDaysThreshold) <= 0){
            return 0L;
        }

        return (daysPassed - issuanceDaysThreshold) * finePerDay;

//        Date issueDate = transaction.getCreatedAt();
//        long issueDateEpoch = issueDate.getTime(); // epoch is the number of milliseconds passed since 1st Jan 1970 till the issue date
//
//        long dueDateEpoch = issueDateEpoch + issuanceDaysThreshold * 1296000000;
//
//        long currentDateEpoch = System.currentTimeMillis();
//        long timeDiffEpoch = currentDateEpoch - dueDateEpoch;
//
//        if(timeDiffEpoch < 0){
//            return 0L;
//        }
//
//        Long daysPassedDueDate = TimeUnit.DAYS.convert(timeDiffEpoch, TimeUnit.MILLISECONDS);
//        return daysPassedDueDate * finePerDay;


    }


    public List<String> convertToLowerCase(List<String> cities){
        return cities.stream().map(x -> x.toLowerCase()).collect(Collectors.toList());
    }
}
