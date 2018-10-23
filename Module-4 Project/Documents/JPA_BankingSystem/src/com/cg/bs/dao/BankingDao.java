package com.cg.bs.dao;

import java.util.List;
import com.cg.bs.entities.PayeeTable;
import com.cg.bs.entities.ServiceTracker;
import com.cg.bs.entities.Transactions;

public interface BankingDao 
{
	public boolean validateUser(int userName, String password);
	public List<Integer> getUserAccounts(int userName);
	
	public List<Transactions> miniStatement(int accNo);
	public List<Transactions> detailedStatement(int accNo,String startDate,String endDate);
	
	public String getCurrentAddress(int userName);
	public String updateAddress(int userName);
	public String changePassword(int userName,String oldPass,String newPass);
	
	public String chequeRequest(int accNo);
	public List<ServiceTracker> getServiceRequestById(int userName, int requestID);
	
	public List<ServiceTracker> getAllServiceRequested(int accNo);
	
	public double getAcAvailableBalance(int fromAcChoice,int amt);
	public double fundTransfer(int toAcChoice,int fromAcChoice,int amt);
	public List<PayeeTable> PayeeAccountId(int userName);
	
	public String addPayee(int user_id,int payee_account_id,String nickname);
	public boolean isAccountExist(int account_no, int userName);
	public boolean checkTransactionPassword(int userName, String tnxPassword);
	public boolean isUserExist(int username);
}
