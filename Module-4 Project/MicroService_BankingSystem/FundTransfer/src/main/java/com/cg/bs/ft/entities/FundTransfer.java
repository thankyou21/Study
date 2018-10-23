package com.cg.bs.ft.entities;

public class FundTransfer 
{
	int userId, fromAc, toAc;
	double amt;
	String tnxPassword;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFromAc() {
		return fromAc;
	}
	public void setFromAc(int fromAc) {
		this.fromAc = fromAc;
	}
	public int getToAc() {
		return toAc;
	}
	public void setToAc(int toAc) {
		this.toAc = toAc;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
	public String getTnxPassword() {
		return tnxPassword;
	}
	public void setTnxPassword(String tnxPassword) {
		this.tnxPassword = tnxPassword;
	}
}
