package com.example.minor_project1.controller;

import com.example.minor_project1.dtos.CreateBookRequest;
import com.example.minor_project1.models.Book;
import com.example.minor_project1.services.BookService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return this.bookService.findAll();
    }

    @GetMapping("/find-by-name")
    public List<Book> findBooks(@RequestParam("name") String name){
        return this.bookService.findByName(name);
    }

    @GetMapping("/find-by-genre")
    public List<Book> findBooksByGenre(@RequestParam("genre") String genre){
        return this.bookService.findByGenre(genre);
    }
}
