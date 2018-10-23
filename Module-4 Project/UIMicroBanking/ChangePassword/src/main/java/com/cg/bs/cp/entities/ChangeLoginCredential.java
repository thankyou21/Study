package com.cg.bs.cp.entities;

public class ChangeLoginCredential 
{
	int userId;
	String oldPassword, newPassword, confirmNewPassword;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}
	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}
	@Override
	public String toString() {
		return "ChangeLoginCredential [userId=" + userId + ", oldPassword="
				+ oldPassword + ", newPassword=" + newPassword
				+ ", confirmNewPassword=" + confirmNewPassword + "]";
	}
	
	
}
