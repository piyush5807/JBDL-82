package com.example.demo_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSecurityApplication.class, args);

//		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//		// During signup
//		String encodedString = passwordEncoder.encode("karan@123");  // $2a$10$G31TYubdJB8iPKV8WHzuGO
//		String encodedString2 = passwordEncoder.encode("rahul@123"); // $2a$10$3XpBGE/6ax46xJ.502uKz.
//
////		// Coming from login page
////		passwordEncoder.matches("karan@123", encodedString);
//
//		System.out.println(encodedString);
//		System.out.println(encodedString2);
	}

}
