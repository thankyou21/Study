package com.cg.bs.dao;

import java.util.List;

import com.cg.bs.entities.AccountMaster;
import com.cg.bs.entities.Customer;
import com.cg.bs.entities.Transactions;
import com.cg.bs.entities.UserTable;

public interface AdminDao {
	public String addCustomer(Customer cust);

	public int addUser(UserTable ut);

	public int addAccount(AccountMaster am);

	public boolean chechUser(int userId);
	
	public List<Transactions> getPeriodicalTransaction(String startDate, String endDate) ;
}
