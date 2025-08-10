package com.example.minor_project1.controller;

import com.example.minor_project1.dtos.ListTransactionDTO;
import com.example.minor_project1.models.Transaction;
import com.example.minor_project1.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue")
    public String issueTxn(@RequestParam("student-id") Integer studentId,
                           @RequestParam("book-id") Integer bookId){
        return transactionService.issueTxn(studentId, bookId);
    }

    @PostMapping("/return")
    public String returnTxn(@RequestParam("student-id") Integer studentId,
                            @RequestParam("book-id") Integer bookId
    ){
        return transactionService.returnTxn(studentId, bookId);
    }

    @GetMapping("/all") // admin
    public List<Transaction> getTransactions(@RequestBody ListTransactionDTO listTransactionDTO){
        return null;
    }

    @GetMapping("") // student
    public List<Transaction> getTransactions(@RequestParam("startDate") Long startDate,
                                                      @RequestParam("endDate") Long endDate){
        // Fetch the studentId from security context
        return null;
    }







}
