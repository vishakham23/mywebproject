package com.javatechie.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyWebProjectApplication {

	@GetMapping("/message")
	public String getMessage(){
		return "Hi Vishakha!! This should sync to Jenkins";
	}

	public static void main(String[] args) {
		SpringApplication.run(MyWebProjectApplication.class, args);
	}

}
