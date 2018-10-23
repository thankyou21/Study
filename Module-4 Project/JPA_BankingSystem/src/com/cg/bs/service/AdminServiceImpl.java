package com.cg.bs.service;


import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.cg.bs.dao.AdminDao;
import com.cg.bs.dao.AdminDaoImpl;
import com.cg.bs.entities.AccountMaster;
import com.cg.bs.entities.Customer;
import com.cg.bs.entities.Transactions;
import com.cg.bs.entities.UserTable;
import com.cg.bs.exception.BankingException;


public class AdminServiceImpl implements AdminService {

	static Scanner sc = new Scanner(System.in);
	AdminDao adao = new AdminDaoImpl();
	
	

	@Override
	public boolean chechUser(int userId) {
		return adao.chechUser(userId);
	}


	@Override
	public List<Transactions> getPeriodicalTransaction(String startDate,
			String endDate) {
		
		return adao.getPeriodicalTransaction(startDate, endDate);
	}


	@Override
	public String addCustomer(Customer cust) {
		return adao.addCustomer(cust);
		
	}


	@Override
	public int addUser(UserTable ut) {
		return adao.addUser(ut);
		
	}


	@Override
	public int addAccount(AccountMaster am) {
		return adao.addAccount(am);
		
	}


	@Override
	public boolean validateCustomerName(String customer_name) throws BankingException {
		String namePattern = "[A-Z][a-z]+";
		if(Pattern.matches(namePattern, customer_name))
			return true;
		else
			throw new BankingException("Invalid Customer Name. Name should start with capital letter "+"and only Characters allowed.");
		
	}


	@Override
	public boolean validateEmail(String email) throws BankingException {
		String mailPattern = "[a-z0-9]+@[a-z]+.[a-z]{2,3}";
		if(Pattern.matches(mailPattern, email)) 
			return true;
		else
			throw new BankingException("Invalid Email id.");
	}


	@Override
	public boolean validatAccType(String account_Type) throws BankingException {
	if(account_Type.equalsIgnoreCase("Savings") || account_Type.equalsIgnoreCase("current"))
		return true;
	else
		throw new BankingException("Account Type can be either Savings / Current");
	}


	@Override
	public boolean validateMinBal(double account_Balance) throws BankingException {
		if(account_Balance > 3000.0)
			return true;
		else
			throw new BankingException("Minimum opening balance cannot be less than 3000.0");
	}



	@Override
	public boolean validateDate(String date) throws BankingException {
		String dateFormat = "^(([0-9])|([0-2][0-9])|([3][0-1]))"+"-(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"+"-[0-9]{2}$";
		if(Pattern.matches(dateFormat, date)) 
			return true;
		else
			throw new BankingException("Invalid Date format. Please enter date in DD-MMM-YY format");
	}
	
	
}
