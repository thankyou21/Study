package com.example.MultipleUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/emp")
public class EmployeeServices 
{
	ArrayList<Employee> empArr = new ArrayList<Employee>();
	
	@GetMapping(value="/select/{id}", produces=MediaType.APPLICATION_XML_VALUE)
	public Employee readEmployee(@PathVariable("id") int id)
	{
		return empArr.get(id-1);
	}
	
	@PostMapping(value="/insert", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Employee> insertEmployee(@RequestBody ArrayList<Employee> emp )
	{
		empArr=emp;
		return empArr;
	}
	
}
