package com.cg.bs.ft.FundTransfer.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="UserTable")
public class UserTable 
{
	@Id
	int userId;
	String loginPassword, secretQuestion, tnxPassword, pancard;
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
	public String getTnxPassword() {
		return tnxPassword;
	}
	public void setTnxPassword(String tnxPassword) {
		this.tnxPassword = tnxPassword;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	
	
}
