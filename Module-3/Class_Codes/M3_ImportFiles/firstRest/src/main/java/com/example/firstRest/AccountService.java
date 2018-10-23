package com.example.firstRest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController   // equivalent to @Controller + @RequestMapping
public class AccountService 
{
	@GetMapping("/hello/{any}")
	public String sayHello(@PathVariable("any") String name)
	{
		return "Hello, " + name + ". ";
	}
}
