package com.cg.bs.ft.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="AccountMaster")
public class AccountMaster 
{
	@Id
	int acNumber;
	int userId;
	String acType;
	double acBalance;
	Date acOpenDate;
	
	public AccountMaster(int acNumber, int userId, String acType,
			double acBalance) {
		super();
		this.acNumber = acNumber;
		this.userId = userId;
		this.acType = acType;
		this.acBalance = acBalance;
		this.acOpenDate = new Date();
	}
	public int getAcNumber() {
		return acNumber;
	}
	public void setAcNumber(int acNumber) {
		this.acNumber = acNumber;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAcType() {
		return acType;
	}
	public void setAcType(String acType) {
		this.acType = acType;
	}
	public double getAcBalance() {
		return acBalance;
	}
	public void setAcBalance(double acBalance) {
		this.acBalance = acBalance;
	}
	public Date getAcOpenDate() {
		return acOpenDate;
	}
	public void setAcOpenDate(Date acOpenDate) {
		this.acOpenDate = acOpenDate;
	}
}
