package com.example.bharatfd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class BharatFdApplication {

	public static void main(String[] args) {
		SpringApplication.run(BharatFdApplication.class, args);
	}

}
