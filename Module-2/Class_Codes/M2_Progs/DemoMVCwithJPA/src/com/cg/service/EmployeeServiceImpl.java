package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.EmployeeDao;
import com.cg.entities.Employee;

@Service("eSer")
@Transactional
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	EmployeeDao edao;
	@Override
	public int insertEmp(Employee emp) 
	{ 	edao.save(emp);	//save is a basic method of JpaRespository 
		return emp.getEmpNo();
	}
	
}
