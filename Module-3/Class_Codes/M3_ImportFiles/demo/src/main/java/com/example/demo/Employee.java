package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value="emp") //value should be same as get bean parameter in DempApplication.java
public class Employee 
{
	@Autowired
	@Qualifier("add") //when there is more than one bean we use qualifier to remove ambiguity
	Address add;
	
	public void welcome()
	{
		System.out.println("Welcome to "+add.getBuildName());
	}
}
