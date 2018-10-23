package com.cg.bs.ac.entities;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="UserTable")
public class UserTable 
{
	@Id
	private int userId;
	private String loginPassword;
	private String secretQuestion;
	private String transactionPassword; 
	private String lockStatus;
	private String pancard;
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
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public UserTable(int userId, String loginPassword, String secretQuestion,
			String transactionPassword, String lockStatus, String pancard) {
		super();
		this.userId = userId;
		this.loginPassword = loginPassword;
		this.secretQuestion = secretQuestion;
		this.transactionPassword = transactionPassword;
		this.lockStatus = lockStatus;
		this.pancard = pancard;
	}
	public UserTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserTable [userId=" + userId + ", loginPassword="
				+ loginPassword + ", secretQuestion=" + secretQuestion
				+ ", transactionPassword=" + transactionPassword
				+ ", lockStatus=" + lockStatus + ", pancard=" + pancard + "]";
	}
	
		
}
