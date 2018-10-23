package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
//OR use
@EnableAutoConfiguration
@ComponentScan("com.example.demo")
public class DemoApplication 
{

	public static void main(String[] args) 
	{
		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		Employee emp = ctx.getBean("emp",Employee.class);
		emp.welcome();
	}
}
