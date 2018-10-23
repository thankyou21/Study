package com.cg.bs.dao;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.bs.entities.AccountMaster;
import com.cg.bs.entities.Customer;
import com.cg.bs.entities.PayeeTable;
import com.cg.bs.entities.ServiceTracker;
import com.cg.bs.entities.Transactions;
import com.cg.bs.entities.UserTable;


public class BankingDaoImpl implements BankingDao
{
	Scanner sc=new Scanner(System.in);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = emf.createEntityManager();Logger daoLogger = null;
	
	public BankingDaoImpl()
	{
		daoLogger = Logger.getLogger(BankingDaoImpl.class);
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@Override
	public boolean validateUser(int userName, String password) 
	{
		return true;
	}

	@Override
	public List<Integer> getUserAccounts(int userName) 
	{
		String query="Select a.Account_ID from AccountMaster a where a.User_ID="+userName;
		TypedQuery<Integer> jpql = em.createQuery(query, Integer.class);
		List<Integer> accList = jpql.getResultList();
		return accList;
	}

	@Override
	public List<Transactions> miniStatement(int accNo) 
	{
		String query ="select t from Transactions t where t.Account_No="+accNo+" order by t.Transaction_ID desc";
		TypedQuery<Transactions> jpql=em.createQuery(query, Transactions.class);
		List<Transactions> temp = jpql.getResultList();
		List<Transactions> tnx = new ArrayList<Transactions>();
		if(temp.size()>10)
		{
			for(int i=0; i<10;i++)
				tnx.add(temp.get(i));
			daoLogger.info("User requested mini transaction for A/c No. "+accNo);
			return tnx;
		}
		else
		{
			daoLogger.info("User requested mini transaction for A/c No. "+accNo);
			return temp;
		}
	}

	@Override
	public List<Transactions> detailedStatement(int accNo, String startDate, String endDate) 
	{
		String query ="select t from Transactions t where t.Account_No = "+accNo+" and t.DateOfTransaction between '"+startDate+"' and '"
				+endDate+"' order by t.Transaction_ID desc";
		TypedQuery<Transactions> jpql=em.createQuery(query, Transactions.class);
		List<Transactions> tnx = jpql.getResultList();
		daoLogger.info("User requested detailed transaction for A/c No. "+accNo+" from "+startDate+" to "+endDate);
		return tnx;
	}
	
	public String getCurrentAddress(int userName)
	{
		UserTable user = em.find(UserTable.class,userName);
		String pc=user.getPancard();
		Customer cust=em.find(Customer.class,pc);
		return cust.getAddress();
		
	}
	
	public String updateAddress(int userName)
	{
		UserTable user = em.find(UserTable.class,userName);
		String pc=user.getPancard();
		Customer cust=em.find(Customer.class,pc);
		cust.setAddress(sc.nextLine());
		em.getTransaction().begin();
		em.merge(cust);
		em.getTransaction().commit();
		daoLogger.info("User "+userName+", updated his/her Address.");
		return "Address Updated...";
	}

	@Override
	public String changePassword(int userName, String oldPass, String newPass) 
	{
		UserTable user = em.find(UserTable.class,userName);
		String pass=user.getLogin_password();
		if(oldPass.equals(pass))
		{
			user.setLogin_password(newPass);
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
			daoLogger.info("User "+userName+", updated his/her Login password.");
			return "Password Changed";
		}
		return "Wrong Password";
	}

	@Override
	public String chequeRequest(int accNo) 
	{
		ServiceTracker chqRqst = new ServiceTracker(accNo,"New Cheque Request","Open");
		em.getTransaction().begin();
		em.persist(chqRqst);
		em.getTransaction().commit();
		daoLogger.info("User requested for cheque book for A/c No. "+accNo+" with service ID: "+chqRqst.getService_ID());
		return "Request Accepted. Your Service ID: "+chqRqst.getService_ID();
	}

	@Override
	public List<ServiceTracker> getAllServiceRequested(int accNo) 
	{
		String query ="Select t from ServiceTracker t where t.Account_ID="+accNo;
		TypedQuery<ServiceTracker> jpql=em.createQuery(query, ServiceTracker.class);
		List<ServiceTracker> serTracker = jpql.getResultList();
		return serTracker;
	}

	@Override
	public List<ServiceTracker> getServiceRequestById(int userName, int requestID) 
	{
		String query ="Select t from ServiceTracker t where t.Service_ID="+requestID
				+" and t.Account_ID IN(Select a from AccountMaster a where a.User_ID="+userName+")";
		TypedQuery<ServiceTracker> jpql = em.createQuery(query, ServiceTracker.class);
		List<ServiceTracker> serTracker = jpql.getResultList();
		return serTracker;
	}
	
	public double getAcAvailableBalance(int fromAcChoice,int amt)
	{
		AccountMaster am = em.find(AccountMaster.class,fromAcChoice);
		return am.getAccount_Balance();
	}
	public boolean checkTransactionPassword(int userName, String tnxPassword)
	{
		UserTable user = em.find(UserTable.class,userName);
		if(user.getTransaction_password().equals(tnxPassword))
			return true;
		else
			return false;
	}
	public double fundTransfer(int toAcChoice,int fromAcChoice,int amt)
	{
		em.getTransaction().begin();
		Transactions debit=new Transactions(amt,fromAcChoice,"Transfer to account number "+toAcChoice,"d");
		em.persist(debit);
		AccountMaster am = em.find(AccountMaster.class,fromAcChoice);
		am.setAccount_Balance(am.getAccount_Balance()-amt);
		em.merge(am);
		double currBalance=am.getAccount_Balance();
		Transactions credit=new Transactions(amt,toAcChoice,"Transfer from account number "+fromAcChoice,"c");
		em.persist(credit);
		am = em.find(AccountMaster.class,toAcChoice);
		am.setAccount_Balance(am.getAccount_Balance()+amt);
		em.merge(am);
		em.getTransaction().commit();
		return currBalance;
	}
	
	public List<PayeeTable> PayeeAccountId(int userName)
	{
		String query="Select p from PayeeTable p where p.User_Id="+userName;
		TypedQuery<PayeeTable> jpql = em.createQuery(query, PayeeTable.class);
		List<PayeeTable> payeeList = jpql.getResultList();
		return payeeList;
	}
	
	public boolean isAccountExist(int account_no, int userName)
	{
		String query;
		if(userName!=0)
			query="Select a.Account_ID from AccountMaster a where a.Account_ID="+account_no+" and a.User_ID<>"+userName;
		else
			query="Select a.Account_ID from AccountMaster a where a.Account_ID="+account_no;
		TypedQuery<Integer> jpql = em.createQuery(query, Integer.class);
		List<Integer> payeeAc = jpql.getResultList();
		if(payeeAc.isEmpty())
			return false;
		else
			return true;
	}
	public String addPayee(int user_id,int payee_account_id,String nickname)
	{
		String query="Select a.Payee_Account_Id from PayeeTable a where a.Payee_Account_Id="+payee_account_id+" and a.User_Id="+user_id;
		TypedQuery<Integer> jpql = em.createQuery(query, Integer.class);
		List<Integer> chkPayeeAc = jpql.getResultList();
		if(chkPayeeAc.isEmpty())
		{
			em.getTransaction().begin();
			PayeeTable pt=new PayeeTable(user_id,payee_account_id,nickname);
			em.persist(pt);
			em.getTransaction().commit();
			daoLogger.info("New Payee "+payee_account_id+nickname+" added by user "+user_id);
			return payee_account_id+nickname;
		}
		return "Payee Account No. "+payee_account_id+" exists.";
	}

	@Override
	public boolean isUserExist(int username) {
	
		UserTable ut = em.find(UserTable.class, username);
		if(ut==null)
			return false;
		else
			return true;
	}
}
