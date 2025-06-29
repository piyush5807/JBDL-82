package com.example.minor_project1.services;

import com.example.minor_project1.dtos.CreateBookRequest;
import com.example.minor_project1.models.Author;
import com.example.minor_project1.models.Book;
import com.example.minor_project1.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService authorService;

    public Book create(CreateBookRequest createBookRequest){

        Book book = createBookRequest.convertToBook();
        Author author = book.getAuthor();    // Till this point we have only email address, country and name for author
        author = this.authorService.getOrCreate(author);  // unique key constraint failed

        book.setAuthor(author);
        return this.bookRepository.save(book);

        /**
         * Option 1
         * 1. You save a book with author as null
         * 2. You save the author object i.e create an author and get the author id
         * 3. Attach the author id with the book object, i.e update the book table set author_id = ? where b_id = ?
         *
         *
         * Option 2
         * 1. You save the author object i.e create an author and get the author id
         * 2. You save the book i.e create the book with the author id so that a FK mapping can exist.
         */


    }

    public Book create(Book book){
        Author author = book.getAuthor();    // Till this point we have only email address, country and name for author

        if(author != null && author.getId() == null) {
            author = this.authorService.getOrCreate(author);  // unique key constraint failed
            book.setAuthor(author);
        }

        return this.bookRepository.save(book);
    }

    public Book findById(Integer bookId){
        return this.bookRepository.findById(bookId).orElse(null);
    }

    public List<Book> findBooksIssued(Integer studentId){
        return this.bookRepository.findByStudentId(studentId);
    }
}
