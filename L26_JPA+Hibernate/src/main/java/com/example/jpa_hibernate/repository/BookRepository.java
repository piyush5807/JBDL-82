package com.example.jpa_hibernate.repository;

import com.example.jpa_hibernate.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
