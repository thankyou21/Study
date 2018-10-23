package com.cg.bs.service;

import java.util.Scanner;
import java.util.regex.Pattern;


import com.cg.bs.dao.LoginDao;
import com.cg.bs.dao.LoginDaoImpl;
import com.cg.bs.entities.UserTable;
import com.cg.bs.exception.BankingException;

public class LoginServiceImpl implements LoginService {

	LoginDao ldao = new LoginDaoImpl();
	Scanner sc = new Scanner(System.in);
	
	
	public boolean verifyCredentials(int username, String password) {
		
			return ldao.verifyCredentials(username, password);
		
	}
	

	@Override
	public String checklockstatus(int username, String password) {
		return ldao.checklockstatus(username, password);
	}


	@Override
	public void setpassword(int username, String new_pass) {
		ldao.setpassword(username, new_pass);
		
	}


	@Override
	public void lockAccount(int username) {
		ldao.lockAccount(username);
		
	}


	@Override
	public boolean adminLogin(int id, String password) {
		
			return ldao.adminLogin(id, password);
		
		
		
	}


	@Override
	public void updateUser(UserTable ut, int username) {
		ldao.updateUser(ut, username);
	}


	@Override
	public String checkSecretAns(int username) {
		return ldao.checkSecretAns(username);
	}


	@Override
	public boolean validateSecretAns(String ans) throws BankingException {
		String ans_ = "[a-zA-z0-9*&!]{3,8}";
		if(Pattern.matches(ans_, ans)) 
			return true;
		else
			throw new BankingException("Answer can contain Numbers, Characters, &, * and !. Minimum 3 & Maximum 8 Characters.");
	}


	@Override
	public boolean validatePassword(String new_pass) throws BankingException {
		String pass = "[a-zA-z0-9*&!]{8,15}";
		if(Pattern.matches(pass, new_pass)) 
			return true;
		else
			throw new BankingException("Password can contain Numbers, Characters, &, * and !. Minimum 8 & Maximum 15 Characters.");
	}


	
	
}
