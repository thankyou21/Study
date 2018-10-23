package com.example.mongoDemo1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;



@RestController
public class EmployeeService 
{
	@Autowired
	DbService ser;
	
	//insert records
	@PostMapping("/insert")
	public String insert(@RequestBody Employee emp)
	{
		if(!ser.existsById(emp.getId()))
		{
			ser.save(emp);
			return "Record Inserted Successfully...\n"+"ID\tName\tAge\tSalary\n"+emp.getId()+"\t"+emp.getName()+"\t"+emp.getAge()+"\t"+emp.getSal()+"\n";
		}
		else
			return "Record exist with Employee ID: "+emp.getId();
	}
	
	//Retrieve all records
	@GetMapping(value="/showall")
	public String readAllEmployee()
	{
		List<Employee> emp = ser.findAll();
		String msg="ID\tName\tAge\tSalary\n";
		for(Employee e : emp)
		{
			msg=msg+e.getId()+"\t"+e.getName()+"\t"+e.getAge()+"\t"+e.getSal()+"\n";
		}
		return msg;
	}
    
	//Retrive one records
	@GetMapping(value="/select/{id}")
	public String readEmployee(@PathVariable("id") Long id)
	{
		if(ser.existsById(id))
		{
			Employee emp=ser.findById(id).get();
			return "ID\tName\tAge\tSalary\n"+emp.getId()+"\t"+emp.getName()+"\t"+emp.getAge()+"\t"+emp.getSal()+"\n";
		}
		else
			return "No Record Found";
			
	}
	
	@DeleteMapping(value="/delete/{id}")
	public String delEmployee(@PathVariable("id") Long id)
	{
		if(ser.existsById(id))
		{
			Employee emp = ser.findById(id).get();
			
			ser.delete(emp);
			return "Record Deleted Successfully...\n"+"ID\tName\tAge\tSalary\n"+emp.getId()+"\t"+emp.getName()+"\t"+emp.getAge()+"\t"+emp.getSal()+"\n";
		}
		else
			return "No Record Found with Employee ID: "+id;
	}
	
	@PostMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE)
	public String editEmployee(@RequestBody Employee emp)
	{
		if(ser.existsById(emp.getId()))
		{
			ser.save(emp);
			return "Record Updated Successfully...\n"+"ID\tName\tAge\tSalary\n"+emp.getId()+"\t"+emp.getName()+"\t"+emp.getAge()+"\t"+emp.getSal()+"\n";
		}
		else
			return "No Record Found with Employee ID: "+emp.getId();
	}
	
	@GetMapping(value="/findbyname/{name}")
	public String searchByName(@PathVariable("name") String name)
	{
		List<Employee> emp = ser.findByName(name);
		if(!emp.isEmpty())
		{
			String msg="ID\tName\tAge\tSalary\n";
			for(Employee e : emp)
			{
				msg=msg+e.getId()+"\t"+e.getName()+"\t"+e.getAge()+"\t"+e.getSal()+"\n";
			}
			return msg;
		}
		else
			return "No rows selected...";
	}
	
	//age filter:greater than
	@GetMapping(value="/findAgeByGreaterThan/{age}")
	public String findAgeByGreaterThan(@PathVariable("age") int age)
	{
		List<Employee> emp = ser.findByAgeGreaterThan(age);
		if(!emp.isEmpty())
		{
			String msg="ID\tName\tAge\tSalary\n";
			for(Employee e : emp)
			{
				msg=msg+e.getId()+"\t"+e.getName()+"\t"+e.getAge()+"\t"+e.getSal()+"\n";
			}
			return msg;
		}
		else
			return "No rows selected...";
	}
	
	//age filter:between a range
		@GetMapping(value="/findByAgeBetween/{fromAge}/{toAge}")
		public String findAgeByGreaterThan(@PathVariable("fromAge") int fromAge,@PathVariable("toAge") int toAge)
		{
			List<Employee> emp = ser.findByAgeBetween(fromAge,toAge);
			if(!emp.isEmpty())
			{
				String msg="ID\tName\tAge\tSalary\n";
				for(Employee e : emp)
				{
					msg=msg+e.getId()+"\t"+e.getName()+"\t"+e.getAge()+"\t"+e.getSal()+"\n";
				}
				return msg;
			}
			else
				return "No rows selected...";
		}
		
		@GetMapping(value="/findByNameLike/{nameLike}")
		public String findByFirstnameLike(@PathVariable("nameLike") String nameLike)
		{
			List<Employee> emp = ser.findByNameLike(nameLike);
			if(!emp.isEmpty())
			{
				String msg="ID\tName\tAge\tSalary\n";
				for(Employee e : emp)
				{
					msg=msg+e.getId()+"\t"+e.getName()+"\t"+e.getAge()+"\t"+e.getSal()+"\n";
				}
				return msg;
			}
			else
				return "No rows selected...";
		}
}
