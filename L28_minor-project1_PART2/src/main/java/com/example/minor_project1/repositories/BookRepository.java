package com.example.minor_project1.repositories;

import com.example.minor_project1.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

//    @Query(value = "select * from books where student_id = ?1", nativeQuery = true)
    List<Book> findByStudentId(Integer studentId);
}
