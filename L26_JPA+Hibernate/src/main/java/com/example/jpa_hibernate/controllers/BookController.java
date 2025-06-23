package com.example.jpa_hibernate.controllers;

import com.example.jpa_hibernate.models.Book;
import com.example.jpa_hibernate.models.Employee;
import com.example.jpa_hibernate.repository.MyJPARepository;
import com.example.jpa_hibernate.services.BookService;
import com.example.jpa_hibernate.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class BookController {

    private static Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookService bookService;

    @PostMapping("/books")
    public void createBook(@RequestBody Book book) throws SQLException {
        bookService.createBook(book);
    }
}
