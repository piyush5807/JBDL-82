package com.example.minor_project1;

import com.example.minor_project1.models.Book;
import com.example.minor_project1.models.Student;
import com.example.minor_project1.models.Transaction;
import com.example.minor_project1.models.TransactionType;
import com.example.minor_project1.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class MinorProject1Application implements CommandLineRunner {

	@Autowired
	TransactionRepository transactionRepository;

	public static void main(String[] args) {
		SpringApplication.run(MinorProject1Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

//		System.out.println("Inside command line runner");
//		Student student = new Student();
//		student.setId(1);
//
//		Book book = new Book();
//		book.setId(3);
//
//		int a = 1/0;
//
//		Transaction transaction = transactionRepository.findTopByStudentAndBookAndTransactionTypeOrderByIdDesc(student, book, TransactionType.ISSUE);
//
//		System.out.println(transaction);

	}
}
