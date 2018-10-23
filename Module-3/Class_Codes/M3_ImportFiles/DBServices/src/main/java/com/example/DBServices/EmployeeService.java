package com.example.DBServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeService 
{
	@Autowired
	DbService ser;
	
	@PostMapping("/insert")
	public String insert(@RequestBody Employee e)
	{
		ser.save(e);
		return "Success";
	}
}
