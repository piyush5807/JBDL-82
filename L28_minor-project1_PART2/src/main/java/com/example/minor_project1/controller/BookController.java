package com.example.minor_project1.controller;

import com.example.minor_project1.dtos.CreateBookRequest;
import com.example.minor_project1.models.Book;
import com.example.minor_project1.services.BookService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    private static Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookService bookService;

    @PostMapping("")
    public Book createBook(@Valid @RequestBody CreateBookRequest createBookRequest){
        logger.info("createBook: request received - {}", createBookRequest);
        return bookService.create(createBookRequest);
//        return bookService.create(createBookRequest.convertToBook());
    }
}
