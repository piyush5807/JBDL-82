package com.example.minor_project1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class MinorProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(MinorProject1Application.class, args);
		System.out.println(UUID.randomUUID());
		System.out.println(UUID.randomUUID());
		System.out.println(UUID.randomUUID());
		
		String a = "adfer423";
		String b = "adfer426";
	}

}
