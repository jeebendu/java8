package com.example.java.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class WelcomeController {
	
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome";
	}

}
