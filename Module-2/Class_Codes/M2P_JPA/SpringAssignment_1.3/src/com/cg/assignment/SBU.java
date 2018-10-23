package com.cg.assignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class SBU 
{
	private String sbuCode;
	private String sbuHead;
	private String sbuName;
	private List<Employee> empList;

	

	public String getSbuCode() {
		return sbuCode;
	}



	public void setSbuCode(String sbuCode) {
		this.sbuCode = sbuCode;
	}



	public String getSbuHead() {
		return sbuHead;
	}



	public void setSbuHead(String sbuHead) {
		this.sbuHead = sbuHead;
	}



	public String getSbuName() {
		return sbuName;
	}



	public void setSbuName(String sbuName) {
		this.sbuName = sbuName;
	}



	public List<Employee> getEmpList() {
		return empList;
	}



	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}



	@Override
	public String toString() {
		return "SBU : sbuCode=" + sbuCode + ", sbuHead=" + sbuHead + ", sbuName=" + sbuName + empList ;
	}
	
	
}
