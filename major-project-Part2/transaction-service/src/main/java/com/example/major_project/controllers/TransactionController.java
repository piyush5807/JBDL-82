package com.example.major_project.controllers;

import com.example.major_project.dto.CreateTransactionDTO;
import com.example.major_project.model.Transaction;
import com.example.major_project.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("")
    public Transaction send(@RequestBody CreateTransactionDTO createTransactionDTO) {

        return transactionService.send(createTransactionDTO);
    }
}
