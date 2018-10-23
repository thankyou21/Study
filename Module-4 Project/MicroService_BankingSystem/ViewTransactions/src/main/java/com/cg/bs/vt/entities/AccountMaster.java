package com.cg.bs.vt.entities;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="AccountMaster")
public class AccountMaster 
{
	@Id
	private int accountId;
	private int userId;
	private String accountType;
	private double accountBalance;
	Date openDate;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	@Override
	public String toString() {
		return "AccountMaster [accountId=" + accountId + ", userId=" + userId
				+ ", accountType=" + accountType + ", accountBalance="
				+ accountBalance + ", openDate=" + openDate + "]";
	}
	public AccountMaster(int accountId, int userId, String accountType,
			double accountBalance, Date openDate) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.openDate = openDate;
	}
	public AccountMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
