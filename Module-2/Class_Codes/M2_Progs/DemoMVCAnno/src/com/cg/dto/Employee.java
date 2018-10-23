package com.cg.dto;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;


public class Employee 
{
	@NotNull(message="Employee ID is mandatory.")
	private Integer empNo;
	
	@NotEmpty(message="Name is mandatory.")
	@Pattern(regexp="[A-Za-z]{3,20}", message="Name should contain a minimum of 3 and maximum of 20 letters")
	private String empName;
	
	@NotNull(message="Age is mandatory.")
	private Integer age;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int empNo, String empName, int age) 
	{
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.age = age;
	}

	

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", age="
				+ age + "]";
	}
}
