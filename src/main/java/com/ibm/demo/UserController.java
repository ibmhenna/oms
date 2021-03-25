package com.ibm.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@GetMapping("/hello")//"/"for no path
	String hello() {
		return "Hello";
	}

}
