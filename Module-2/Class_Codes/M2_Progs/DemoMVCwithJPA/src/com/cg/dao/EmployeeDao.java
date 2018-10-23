package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entities.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>
{
	
}
