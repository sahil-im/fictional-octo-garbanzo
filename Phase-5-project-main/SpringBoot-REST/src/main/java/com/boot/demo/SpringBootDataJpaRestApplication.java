package com.boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootDataJpaRestApplication { 
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaRestApplication.class, args);
	}

}
