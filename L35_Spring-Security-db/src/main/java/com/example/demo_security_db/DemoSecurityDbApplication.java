package com.example.demo_security_db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class DemoSecurityDbApplication implements CommandLineRunner {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	DemoUserRepository demoUserRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoSecurityDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		DemoUser demoUser = new DemoUser();
		demoUser.setUsername("Prashant");
		demoUser.setPassword(passwordEncoder.encode("prashant123"));
		demoUser.setAuthorities("student");

		DemoUser demoUser2 = new DemoUser();
		demoUser2.setUsername("Aman");
		demoUser2.setPassword(passwordEncoder.encode("aman123"));
		demoUser2.setAuthorities("admin:librarian");

//		demoUserRepository.saveAll(Arrays.asList(demoUser2, demoUser));


	}
}
