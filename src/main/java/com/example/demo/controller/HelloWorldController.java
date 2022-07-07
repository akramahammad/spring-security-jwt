package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/role")
	@PreAuthorize("hasRole('admin')")
	public String role() {
		return "Only Admin User";
	}

}
