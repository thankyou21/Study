package com.cg.bs.vt.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Transactions")
public class Transactions 
{
	@Id
	private int accountNo;
	private int tranAmount, transactionId;
	private String tranDescription, transactionType;
	Date dateOfTransaction;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getTranAmount() {
		return tranAmount;
	}
	public void setTranAmount(int tranAmount) {
		this.tranAmount = tranAmount;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getTranDescription() {
		return tranDescription;
	}
	public void setTranDescription(String tranDescription) {
		this.tranDescription = tranDescription;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", tranAmount="
				+ tranAmount + ", accountNo=" + accountNo
				+ ", tranDescription=" + tranDescription + ", transactionType="
				+ transactionType + ", dateOfTransaction=" + dateOfTransaction
				+ "]";
	}
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transactions(int transactionId, int tranAmount, int accountNo,
			String tranDescription, String transactionType,
			Date dateOfTransaction) {
		super();
		this.transactionId = transactionId;
		this.tranAmount = tranAmount;
		this.accountNo = accountNo;
		this.tranDescription = tranDescription;
		this.transactionType = transactionType;
		this.dateOfTransaction = dateOfTransaction;
	}
	
	
}
