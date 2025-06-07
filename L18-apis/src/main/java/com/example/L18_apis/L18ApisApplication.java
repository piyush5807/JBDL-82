package com.example.L18_apis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class L18ApisApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(L18ApisApplication.class, args);

//		Thread.sleep(30000);
//
//		int a = 1 / 0;
//
//		System.out.println("Inside main function after exception...");

		// oom - production environments, mostly due to memory leaks - heap dump // jmap
		// deadlocks - t1 --> t2 --> t3 --> t1 - thread dump  // jstack
	}

}
