package com.example.MessageConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class MessageConsumer 
{
	@Autowired
	RestTemplate rt;
	
	@GetMapping("/select/{id}")
	public Object consume(@PathVariable("id")int id)
	{
		String url="http://localhost:8085/emp/select/"+id;
		return (rt.getForEntity(url,String.class));
	}
	
	@GetMapping("/showall")
	public Object showall()
	{
		String url="http://localhost:8085/emp/showall";
		return (rt.getForEntity(url,String.class));
	}
	
	@GetMapping("/insert/{id}/{name}/{age}/{salary}")
	public Object update(@PathVariable("id")Long id, @PathVariable("name")String name, @PathVariable("age")Integer age, @PathVariable("salary")Integer salary)
	{
		String url="http://localhost:8085/emp/insert";
		HttpHeaders h = new HttpHeaders();
		h.setContentType(MediaType.APPLICATION_JSON);
		Employee emp = new Employee();
		emp.setAge(age);
		emp.setId(id);
		emp.setName(name);
		emp.setSalary(salary);
		HttpEntity<Employee> emp2 = new HttpEntity<Employee>(emp,h);
		return (rt.postForObject(url, emp2,String.class));
	}
	
	@GetMapping("/update/{id}/{name}/{age}/{salary}")
	public Object insert(@PathVariable("id")Long id, @PathVariable("name")String name, @PathVariable("age")Integer age, @PathVariable("salary")Integer salary)
	{
		String url="http://localhost:8085/emp/update";
		HttpHeaders h = new HttpHeaders();
		h.setContentType(MediaType.APPLICATION_JSON);
		Employee emp = new Employee();
		emp.setAge(age);
		emp.setId(id);
		emp.setName(name);
		emp.setSalary(salary);
		HttpEntity<Employee> emp2 = new HttpEntity<Employee>(emp,h);
		return (rt.postForObject(url, emp2,String.class));
	}
	
	@GetMapping("/findbyname/{name}")
	public Object findByName(@PathVariable("name")String name)
	{
		String url="http://localhost:8085/emp/findbyname/"+name;
		
		return (rt.getForEntity(url,String.class));
	}
	
	@GetMapping("/delete/{id}")
	public Object findByName(@PathVariable("id")int id)
	{
		String url="http://localhost:8085/emp/delete/"+id;
		rt.delete(url);
		return "record deleted successfully.";
	}
}
