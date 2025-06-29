package com.example.minor_project1.controller;

import com.example.minor_project1.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
