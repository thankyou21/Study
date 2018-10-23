package com.cg.bs.service;

import java.util.List;

import com.cg.bs.entities.AccountMaster;
import com.cg.bs.entities.Customer;
import com.cg.bs.entities.Transactions;
import com.cg.bs.entities.UserTable;
import com.cg.bs.exception.BankingException;

public interface AdminService {


	boolean chechUser(int userId);

	List<Transactions> getPeriodicalTransaction(String startDate, String endDate);

	String addCustomer(Customer cust);

	int addUser(UserTable ut);

	int addAccount(AccountMaster am);
	
	public boolean validateCustomerName(String customer_name) throws BankingException;

	public boolean validateEmail(String email) throws BankingException;

	public boolean validatAccType(String account_Type) throws BankingException;

	public boolean validateMinBal(double account_Balance) throws BankingException;

	public boolean validateDate(String startDate) throws BankingException;

}
