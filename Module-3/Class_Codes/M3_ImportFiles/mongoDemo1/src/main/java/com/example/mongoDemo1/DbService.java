package com.example.mongoDemo1;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DbService extends MongoRepository<Employee,Long>
{
	public List<Employee> findByName(String name);
	
	//age gt and between, lt is similar as gt;
	public List<Employee> findByAgeGreaterThan(int age);
	public List<Employee> findByAgeBetween(int fromAge, int toAge);
	
	public List<Employee> findByNameNotNull();
	public List<Employee> findByNameLike(String nameLike);
	public List<Employee> findByNameNot(String nameNot);
}
