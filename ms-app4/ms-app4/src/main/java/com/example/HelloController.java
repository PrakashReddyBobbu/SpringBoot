package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("test1")
	public String test() {
		
		return "From ServerAppApplication " + this;
		
	}

}
