package com.example.MessageProducer;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/emp")
public class EmployeeServices 
{
	@Autowired
	EmployeeDao eDao;
	
	////Retrive one records
	//@GetMapping(value="/select", produces=MediaType.APPLICATION_XML_VALUE)
	//@RequestMapping(path="/select", method=RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	@GetMapping(value="/select/{id}")//, produces=MediaType.APPLICATION_XML_VALUE)
	public String readEmployee(@PathVariable("id") Long id)
	{
		if(eDao.existsById(id))
		{
			Employee emp=eDao.getOne(id);
			System.out.println(emp);
			return "ID\tName\tAge\tSalary\n"+emp.getId()+"\t"+emp.getName()+"\t"+emp.getAge()+"\t"+emp.getSalary()+"\n";
			//return emp;
		}
		else
			return "No Record Found";
			
	}
	
	//insert records
	@PostMapping(value="/insert", consumes=MediaType.APPLICATION_JSON_VALUE)//, produces=MediaType.APPLICATION_XML_VALUE)
	public String insertEmployee(@RequestBody Employee emp)
	{
		if(!eDao.existsById(emp.getId()))
		{
			eDao.save(emp);
			System.out.println(emp);
			return "Record Inserted Successfully...\n"+"ID\tName\tAge\tSalary\n"+emp.getId()+"\t"+emp.getName()+"\t"+emp.getAge()+"\t"+emp.getSalary()+"\n";
		}
		else
			return "Record exist with Employee ID: "+emp.getId();
	}
	
	//Retrieve all records
	@GetMapping(value="/showall")//,  produces=MediaType.APPLICATION_XML_VALUE)
	public String readAllEmployee()
	{
		List<Employee> emp = eDao.findAll();
		String msg="ID\tName\tAge\tSalary\n";
		for(Employee e : emp)
		{
			msg=msg+e.getId()+"\t"+e.getName()+"\t"+e.getAge()+"\t"+e.getSalary()+"\n";
		}
		return msg;
	}
	
	@DeleteMapping(value="/delete/{id}", produces=MediaType.APPLICATION_XML_VALUE)
	public String delEmployee(@PathVariable("id") Long id)
	{
		if(eDao.existsById(id))
		{
			Employee emp = eDao.findById(id).get();
			eDao.delete(emp);
			return "Record Deleted Successfully...\n"+"ID\tName\tAge\tSalary\n"+emp.getId()+"\t"+emp.getName()+"\t"+emp.getAge()+"\t"+emp.getSalary()+"\n";
		}
		else
			return "No Record Found with Employee ID: "+id;
	}
	
	@PostMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE)//, produces=MediaType.APPLICATION_XML_VALUE)
	public String editEmployee(@RequestBody Employee emp)
	{
		if(eDao.existsById(emp.getId()))
		{
			eDao.save(emp);
			return "Record Updated Successfully...\n"+"ID\tName\tAge\tSalary\n"+emp.getId()+"\t"+emp.getName()+"\t"+emp.getAge()+"\t"+emp.getSalary()+"\n";
		}
		else
			return "No Record Found with Employee ID: "+emp.getId();
	}
	
	@GetMapping(value="/findbyname/{name}")//, produces=MediaType.APPLICATION_XML_VALUE)
	public String searchByName(@PathVariable("name") String name)
	{
		List<Employee> emp = eDao.findByName(name);
		if(!emp.isEmpty())
		{
			String msg="ID\tName\tAge\tSalary\n";
			for(Employee e : emp)
			{
				msg=msg+e.getId()+"\t"+e.getName()+"\t"+e.getAge()+"\t"+e.getSalary()+"\n";
			}
			return msg;
		}
		else
			return "No rows selected...";
	}
}
