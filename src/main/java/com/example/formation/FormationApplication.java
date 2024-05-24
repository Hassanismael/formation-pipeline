package com.example.formation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FormationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormationApplication.class, args);
	}

	@GetMapping("/hello")
	public String Hello(){
		return "<h2> Hello branch dev</h2>";
	}
}
