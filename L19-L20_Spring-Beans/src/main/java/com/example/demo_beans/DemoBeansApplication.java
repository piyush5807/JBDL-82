package com.example.demo_beans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(
////		basePackages = "my_test_pkg"
//)
public class DemoBeansApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBeansApplication.class, args);
	}

}
