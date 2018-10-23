package com.cg.bs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.bs.entities.AccountMaster;
import com.cg.bs.entities.Customer;
import com.cg.bs.entities.Transactions;
import com.cg.bs.entities.UserTable;

public class AdminDaoImpl implements AdminDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = emf.createEntityManager();
	Logger daoLogger = null;
	public AdminDaoImpl()
	{
		daoLogger = Logger.getLogger(AdminDaoImpl.class);
		PropertyConfigurator.configure("log4j.properties");
	}
	@Override
	public String addCustomer(Customer cust) {
		em.getTransaction().begin();
		em.persist(cust);
		em.getTransaction().commit();
		daoLogger.info("New Customer Added with details : "+cust);
		return cust.getPancard();
	}

	@Override
	public int addUser(UserTable ut) {
		em.getTransaction().begin();
		em.persist(ut);
		em.getTransaction().commit();
		daoLogger.info("New User Added with details : "+ut);
		return ut.getUser_id();
	}

	@Override
	public int addAccount(AccountMaster am) {
		em.getTransaction().begin();
		em.persist(am);
		em.getTransaction().commit();
	    daoLogger.info("New Account Added with details : "+am);
		return am.getAccount_ID();
	}

	@Override
	public boolean chechUser(int userId) {
		em.getTransaction().begin();
		TypedQuery<Long> query = em.createQuery("SELECT COUNT(*) FROM UserTable  WHERE user_id = :id", Long.class);
	    query.setParameter("id", userId);  
	    em.getTransaction().commit();
	    return query.getSingleResult() > 0;
	}
	
	public List<Transactions> getPeriodicalTransaction(String startDate, String endDate) 
	{
		String query ="select t from Transactions t where t.DateOfTransaction between '"+startDate+"' and '"
				+endDate+"' order by t.Transaction_ID desc";
		TypedQuery<Transactions> jpql=em.createQuery(query, Transactions.class);
		List<Transactions> tnx = jpql.getResultList();
		return tnx;
	}
	
}
