package com.capgemini.simplerestapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.simplerestapp.entity.Greeter;

@RestController
public class GreeterController {
	
	@GetMapping("/greet/{name}")
	public String greet(@PathVariable String name) {
		return "Hello : " + name;
	}
	
	@GetMapping("/greet")
	public Greeter greet() {
		return new Greeter("greet", "Hello....");
	}
	
	@PostMapping(value = "/greet")
	public Greeter addGreeter(@RequestBody Greeter greeter) {
		System.out.println(greeter);
		return greeter;
	}
}




