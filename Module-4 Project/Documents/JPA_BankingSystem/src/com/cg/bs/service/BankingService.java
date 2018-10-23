package com.cg.bs.service;

import java.util.List;

import com.cg.bs.entities.PayeeTable;
import com.cg.bs.entities.ServiceTracker;
import com.cg.bs.entities.Transactions;

public interface BankingService 
{
	public boolean validateUser(int userName, String password);
	public List<Integer> getUserAccounts(int userName);
	public List<Transactions> miniStatement(int accNo);
	public List<Transactions> detailedStatement(int accNo,String startDate,String endDate);
	public int getCurrentAcNo(int userName);
	public String getCurrentAddress(int userName);
	public String updateAddress(int userName);
	public String changePassword(int userName,String oldPass,String newPass);
	public String chequeRequest(int accNo);
	public List<ServiceTracker> getAllServiceRequested(int accNo);
	public List<ServiceTracker> getServiceRequestById(int userName, int requestID);
	public double getAcAvailableBalance(int fromAcChoice,int amt);
	public double fundTransfer(int toAcChoice,int fromAcChoice,int amt);
	public List<PayeeTable> getPayeeAccountId(int userName);
	public String addPayee(int user_id,int payee_account_id,String nickname);
	public boolean isAccountExist(int account_no, int userName);
	public int getURN();
	public String validateAndCreatePayeeAccount(int userName);
	public void checkBalanceAndMakeTransaction(int toAcChoice,int fromAcChoice,int amt);
	public boolean checkTransactionPassword(int userName, String tnxPassword);
	public boolean isUserExist(int username);

}
