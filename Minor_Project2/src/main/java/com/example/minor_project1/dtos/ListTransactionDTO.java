package com.example.minor_project1.dtos;

import com.example.minor_project1.models.TransactionStatus;
import com.example.minor_project1.models.TransactionType;

public class ListTransactionDTO {

    private Long startDate;
    private Long endDate;

    private Integer bookId;
    private Integer studentId;

    private TransactionStatus status;

    private TransactionType transactionType;
}
