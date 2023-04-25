package com.api.registercustomers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RegisterCustomersApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterCustomersApplication.class, args);
	}
	
	@GetMapping("/")
	public  String index() {
		return "Olá mundo!";
	}
	
}