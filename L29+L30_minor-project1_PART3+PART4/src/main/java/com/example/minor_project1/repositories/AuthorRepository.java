package com.example.minor_project1.repositories;

import com.example.minor_project1.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query
    Author findByEmail(String email);
}
