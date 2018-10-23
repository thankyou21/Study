package com.cg.bs.dao;

import com.cg.bs.entities.UserTable;


public interface LoginDao {

	public boolean verifyCredentials(int username, String password);

	public String checklockstatus(int username, String password);

	public void lockAccount(int username);

	public String checkSecretAns(int username);

	public void setpassword(int username, String string);

	public boolean adminLogin(int id, String password);

	public void updateUser(UserTable ut, int username);


	

	
}
