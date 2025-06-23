package com.example.jpa_hibernate;

import com.example.jpa_hibernate.models.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);

		Calculator calculator = new USCalculator();


//		Employee employee = Employee.builder()
//				.id(1)
//				.name("ABC")
//				.build();
//
//		System.out.println(employee);
	}

}
