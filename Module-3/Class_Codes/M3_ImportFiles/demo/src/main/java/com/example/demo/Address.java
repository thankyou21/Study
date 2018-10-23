package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service(value="add")
public class Address 
{
	public String getBuildName()
	{
		return "Hotel Taj";
	}
}
