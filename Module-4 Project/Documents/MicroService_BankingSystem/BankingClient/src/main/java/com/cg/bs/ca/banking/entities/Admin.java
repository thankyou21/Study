package com.cg.bs.ca.banking.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Admin")
public class Admin 
{
	@Id
	private int adminId=0;
	private String password="null";
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", password=" + password + "]";
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int adminId, String password) {
		super();
		this.adminId = adminId;
		this.password = password;
	}
	
	
}
