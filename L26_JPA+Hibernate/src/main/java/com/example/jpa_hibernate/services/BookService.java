package com.example.jpa_hibernate.services;

import com.example.jpa_hibernate.models.Book;
import com.example.jpa_hibernate.models.Employee;
import com.example.jpa_hibernate.repository.BookRepository;
import com.example.jpa_hibernate.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service // @Component
public class BookService {

    @Autowired
    BookRepository bookRepository;

    private static Logger logger = LoggerFactory.getLogger(BookService.class);


    public void createBook(Book book) throws SQLException {
        bookRepository.save(book);
    }
}
