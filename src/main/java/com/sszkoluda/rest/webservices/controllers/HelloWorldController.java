package com.sszkoluda.rest.webservices.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sszkoluda.rest.webservices.model.Greeting;

/**
 * @author HP
 *
 */
@RestController
@RequestMapping("/api")
public class HelloWorldController {

	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
	@GetMapping(path = "/hello-world")
	public Greeting helloWorld(@RequestParam(name="name",required=true, defaultValue="Stranger") String name) {
		
		return new Greeting(counter.incrementAndGet(),String.format(template, "Sebastian"));
	}
	
}
