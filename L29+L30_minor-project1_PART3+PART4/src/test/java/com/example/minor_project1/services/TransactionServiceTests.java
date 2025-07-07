package com.example.minor_project1.services;

import com.example.minor_project1.models.*;
import com.example.minor_project1.repositories.StudentRepository;
import com.example.minor_project1.repositories.TransactionRepository;
import jakarta.validation.ValidationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

@RunWith(MockitoJUnitRunner.class)     // Which type of runner I need for writing test cases
public class TransactionServiceTests {

    @InjectMocks
    TransactionService transactionService;

    @Mock   // create an object of studentService for transactionServiceTests class
    StudentService studentService;

    @Mock
    TransactionRepository transactionRepository;

    @Mock
    AuthorService authorService;

    @Mock
    BookService bookService;

    @Test  // making this function act like a test case which is independently executable
    public void testIssueTxn(){

        Integer studentId = 1000;
        Integer bookId = 2000;
        Integer transactionId = 5000;
        String externalTransactionId = UUID.randomUUID().toString();

        Book book = new Book();
        book.setId(bookId);
        book.setAvailable(true);
        book.setStudent(null);


        Student student = new Student();
        student.setId(studentId);

        Book updatedBook = new Book();
        updatedBook.setId(bookId);
        updatedBook.setAvailable(false);
        updatedBook.setStudent(student);

        Transaction transaction = new Transaction();      // t2 != t1
        transaction.setId(transactionId);
        transaction.setExternalTxnId(externalTransactionId);
        transaction.setTransactionStatus(TransactionStatus.PENDING);
        transaction.setTransactionType(TransactionType.ISSUE);
        transaction.setStudent(student);
        transaction.setBook(book);

        Transaction updatedTransaction = new Transaction();      // t2 != t1
        updatedTransaction.setId(transactionId);
        updatedTransaction.setExternalTxnId(externalTransactionId);
        updatedTransaction.setTransactionStatus(TransactionStatus.SUCCESS);
        updatedTransaction.setTransactionType(TransactionType.ISSUE);
        updatedTransaction.setStudent(student);
        updatedTransaction.setBook(book);



        Mockito.when(bookService.findById(Mockito.eq(bookId))).thenReturn(book);
        Mockito.when(studentService.findById(Mockito.eq(studentId))).thenReturn(student);
        Mockito.when(bookService.findBooksIssued(Mockito.eq(studentId))).thenReturn(new ArrayList<>());

        Mockito.when(transactionRepository.save(Mockito.any())).thenReturn(transaction);
        Mockito.when(bookService.create((Book) Mockito.any())).thenReturn(updatedBook);
        Mockito.when(transactionRepository.save(Mockito.any())).thenReturn(updatedTransaction);

        String actualExternalTxnId = transactionService.issueTxnUtil(studentId, bookId, 3);

        Mockito.verify(bookService, Mockito.times(1)).findById(Mockito.eq(bookId));
        Mockito.verify(studentService, Mockito.times(1)).findById(Mockito.eq(studentId));
        Mockito.verify(transactionRepository, Mockito.times(2)).save(Mockito.any());
//        Mockito.verify(transactionRepository, Mockito.times(0)).findTopByStudentAndBookAndTransactionTypeOrderByIdDesc(Mockito.any(), Mockito.any(), Mockito.any());

        Assert.assertEquals(externalTransactionId, actualExternalTxnId);
    }

    @Test(expected = ValidationException.class)
    public void testIssueTxn_StudentInvalid(){

        Mockito.when(bookService.findById(Mockito.eq(10))).thenReturn(null);

        transactionService.issueTxnUtil(3, 10, 5);
    }

    @Test
    public void testStringConversion(){

        List<String> cities = Arrays.asList("Udaipur", "Jaipur");


        List<String> output = transactionService.convertToLowerCase(cities);

        for(int i = 0; i < output.size(); i++){
            Assert.assertEquals(cities.get(i).toLowerCase(), output.get(i));
        }
    }
}
