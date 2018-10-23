package com.cg.bs.ac.entities;



public class AddNewCustomer 
{
	private String pancard;
	private String customerName, email, address;
	private int userId;
	private String loginPassword;
	private String secretQuestion;
	private String transactionPassword; 
	private String lockStatus;
	private int accountId;
	private String accountType;
	private double accountBalance;

	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getSecretQuestion() {
		return secretQuestion;
	}
	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}
	public String getTransactionPassword() {
		return transactionPassword;
	}
	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}
	public String getLockStatus() {
		return lockStatus;
	}
	public void setLockStatus(String lockStatus) {
		this.lockStatus = lockStatus;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
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
	
	public AddNewCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddNewCustomer(String pancard, String customerName, String email,
			String address, int userId, String loginPassword,
			String secretQuestion, String transactionPassword,
			String lockStatus, int accountId, String accountType,
			double accountBalance) {
		super();
		this.pancard = pancard;
		this.customerName = customerName;
		this.email = email;
		this.address = address;
		this.userId = userId;
		this.loginPassword = loginPassword;
		this.secretQuestion = secretQuestion;
		this.transactionPassword = transactionPassword;
		this.lockStatus = lockStatus;
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "AddNewCustomer [pancard=" + pancard + ", customerName="
				+ customerName + ", email=" + email + ", address=" + address
				+ ", userId=" + userId + ", loginPassword=" + loginPassword
				+ ", secretQuestion=" + secretQuestion
				+ ", transactionPassword=" + transactionPassword
				+ ", lockStatus=" + lockStatus + ", accountId=" + accountId
				+ ", accountType=" + accountType + ", accountBalance="
				+ accountBalance + "]";
	}
	
	

}
