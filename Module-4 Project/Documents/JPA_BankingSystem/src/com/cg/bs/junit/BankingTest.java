package com.cg.bs.junit;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.bs.dao.BankingDao;
import com.cg.bs.dao.BankingDaoImpl;
import com.cg.bs.dao.LoginDao;
import com.cg.bs.dao.LoginDaoImpl;
import com.cg.bs.entities.Transactions;




public class BankingTest 
{
	static EntityManagerFactory emf = null;
	static EntityManager em = null;
	static BankingDao bDao = null;
	static LoginDao lDao = null;
	static int count=0;
	
	@BeforeClass
	public static void setUp()
	{
		emf = Persistence.createEntityManagerFactory("JPA-PU");
		em = emf.createEntityManager();
		bDao = new BankingDaoImpl();
		lDao = new LoginDaoImpl();
	}
	
	@Test
	public void updateAddressTest()
	{
		System.out.println("updateAddressTest() started");
		int userName = 1022;
		System.out.println("Enter Current Address: ");
		Assert.assertEquals("Address Updated...", bDao.updateAddress(userName));
		count++;
		System.out.println("updateAddressTest() Passed\n");
	}
	
	@Test
	public void miniStatementTest()
	{
		System.out.println("miniStatementTest() started");
		int accNo = 9001;
		String query ="select t from Transactions t where t.Account_No="+accNo+" order by t.Transaction_ID desc";
		TypedQuery<Transactions> jpql=em.createQuery(query, Transactions.class);
		List<Transactions> temp = jpql.getResultList();
		List<Transactions> tnx = new ArrayList<Transactions>();
		if(temp.size()>10)
		{
			for(int i=0; i<10;i++)
				tnx.add(temp.get(i));
			Assert.assertEquals(tnx.size(), bDao.miniStatement(accNo).size());
		}
		else
			Assert.assertEquals(temp.size(), bDao.miniStatement(accNo).size());
		count++;
		System.out.println("miniStatementTest() Passed\n");
	}
	
	@Test
	public void check()
	{
		bDao.fundTransfer(9023,9020,584);
	}
	@Test
	public void verifyCredentialsTest()
	{
		System.out.println("verifyCredentialsTest() started");
		Assert.assertEquals(true,lDao.verifyCredentials(1020, "asdf1234"));
		count++;
		System.out.println("verifyCredentialsTest() Passed\n");
	}
	
	@AfterClass
	public static void tearDown()
	{
		System.out.println("===============================================");
		System.out.println("Test Complete...");
		System.out.println("Total Test Run : 3");
		System.out.println("Test Passed: "+count);
		System.out.println("Test Failed: "+(3-count));
		System.out.println("===============================================");
	}
}
