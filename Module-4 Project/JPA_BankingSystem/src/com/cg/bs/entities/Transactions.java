package com.cg.bs.entities;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="TRANSACTIONS")
public class Transactions {

	@Id
	@SequenceGenerator(name="myseq", sequenceName="tnx_seq_id", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="myseq")
	private int Transaction_ID;
	private int TranAmount, Account_No;
	private String Tran_description, TransactionType;
	private Date  DateOfTransaction;
	
	
	public Date getDateOfTransaction() {
		return DateOfTransaction;
	}
	public void setDateOfTransaction(Date dateOfTransaction) {
		DateOfTransaction = dateOfTransaction;
	}
	public int getTransaction_ID() {
		return Transaction_ID;
	}
	public void setTransaction_ID(int transaction_ID) {
		Transaction_ID = transaction_ID;
	}
	
	
	public int getTranAmount() {
		return TranAmount;
	}
	public void setTranAmount(int tranAmount) {
		TranAmount = tranAmount;
	}
	
	
	public int getAccount_No() {
		return Account_No;
	}
	public void setAccount_No(int account_No) {
		Account_No = account_No;
	}
	
	
	public String getTran_description() {
		return Tran_description;
	}
	public void setTran_description(String tran_description) {
		Tran_description = tran_description;
	}
	
	
	public String getTransactionType() {
		return TransactionType;
	}
	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}
	
	
	@Override
	public String toString() {
		return "Transactions [Transaction_ID=" + Transaction_ID
				+ ", TranAmount=" + TranAmount + ", Account_No=" + Account_No
				+ ", Tran_description=" + Tran_description
				+ ", TransactionType=" + TransactionType
				+ ", DateOfTransaction=" + DateOfTransaction + "]";
	}
	
	
	public Transactions(int tranAmount, int account_No,
			String tran_description, String transactionType) {
		super();
		DateOfTransaction = new Date(new java.util.Date().getTime());
		TranAmount = tranAmount;
		Account_No = account_No;
		Tran_description = tran_description;
		TransactionType = transactionType;
	}
	
	
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
