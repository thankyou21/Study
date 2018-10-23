package com.cg.bs.ca.banking.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Customer")
public class Customer
{
	@Id
	private String pancard;
	private String customer_name, Email, Address;
	
	
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getEmail() {
		return Email;
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
	@Override
	public String toString() {
		return "Customer [Pancard=" + pancard + ", customer_name="
				+ customer_name + ", Email=" + Email + ", Address=" + Address
				+ "]";
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String pancard, String customer_name, String email,
			String address) {
		super();
		this.pancard = pancard;
		this.customer_name = customer_name;
		Email = email;
		Address = address;
	}
	
	
}
