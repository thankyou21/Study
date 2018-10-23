package com.cg.bs.ft.FundTransfer.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Transaction")
public class Transactions 
{
	@Id
	int tnxId;
	String tnxDesc, tnxType;
	Date tnxDate;
	int acNumber;
	double balance;

	public Transactions(int tnxId, String tnxDesc, String tnxType, 
			int acNumber, double balance) {
		super();
		this.tnxId = tnxId;
		this.tnxDesc = tnxDesc;
		this.tnxType = tnxType;
		this.tnxDate = new Date();
		this.acNumber = acNumber;
		this.balance = balance;
	}
	public int getTnxId() {
		return tnxId;
	}
	public void setTnxId(int tnxId) {
		this.tnxId = tnxId;
	}
	public String getTnxDesc() {
		return tnxDesc;
	}
	public void setTnxDesc(String tnxDesc) {
		this.tnxDesc = tnxDesc;
	}
	public String getTnxType() {
		return tnxType;
	}
	public void setTnxType(String tnxType) {
		this.tnxType = tnxType;
	}
	public Date getTnxDate() {
		return tnxDate;
	}
	public void setTnxDate(Date tnxDate) {
		this.tnxDate = tnxDate;
	}
	public int getAcNumber() {
		return acNumber;
	}
	public void setAcNumber(int acNumber) {
		this.acNumber = acNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
