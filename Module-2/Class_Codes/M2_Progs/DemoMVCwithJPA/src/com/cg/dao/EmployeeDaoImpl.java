/*package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.entities.Employee;

@Repository("eDao")
public class EmployeeDaoImpl implements EmployeeDao
{
	@PersistenceContext
	EntityManager em;
	@Override
	public int insertEmployee(Employee emp) 
	{
		em.persist(emp);
		return emp.getEmpNo();
	}

}
*/