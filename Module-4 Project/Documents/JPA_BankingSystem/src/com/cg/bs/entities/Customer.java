package com.cg.bs.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer 
{
	@Id
	private String  Pancard;
	private String Customer_name, Email, Address;

	

	public Customer(String pancard, String customer_name, String email, String address) {
		super();
		Pancard = pancard;
		Customer_name = customer_name;
		Email = email;
		Address = address;
	}

	public String getCustomer_name() {
		return Customer_name;
	}

	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}

	public String getEmail() {
		return Email;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPancard() {
		return Pancard;
	}

	public void setPancard(String pancard) {
		Pancard = pancard;
	}
	
}
