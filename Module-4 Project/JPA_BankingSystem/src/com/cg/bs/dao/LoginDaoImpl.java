package com.cg.bs.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.cg.bs.entities.UserTable;

public class LoginDaoImpl implements LoginDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = emf.createEntityManager();
	
	@Override
	public boolean verifyCredentials(int username, String password) {
		em.getTransaction().begin();
		TypedQuery<Long> query = em.createQuery("SELECT COUNT(u.user_id) FROM UserTable u WHERE u.user_id = :id AND u.login_password = :pass", Long.class);
	    query.setParameter("id", username);
	    query.setParameter("pass", password);  
	    em.getTransaction().commit();
	    return query.getSingleResult() > 0;
		
	}

	@Override
	public String checklockstatus(int username, String password) {
		TypedQuery<String> query = em.createQuery("SELECT u.lock_status FROM UserTable u WHERE u.user_id = :id AND u.login_password = :pass", String.class);
		query.setParameter("id", username);
	    query.setParameter("pass", password); 
		return query.getSingleResult();
	}

	
	@Override
	public String checkSecretAns(int username) {
		TypedQuery<String> query = em.createQuery("SELECT u.secret_question FROM UserTable u WHERE u.user_id = :id", String.class);
		query.setParameter("id", username);
		return query.getSingleResult();
	}

	@Override
	public void lockAccount(int username) {
		em.getTransaction().begin();
		UserTable ut = em.find(UserTable.class, username);
		ut.setLock_status("b");
		em.merge(ut);
		em.getTransaction().commit();
	}

	@Override
	public void setpassword(int username, String password) {
		em.getTransaction().begin();
		UserTable ut = em.find(UserTable.class, username);
		ut.setLogin_password(password);
		em.merge(ut);
		em.getTransaction().commit();
	}

	@Override
	public boolean adminLogin(int id, String password) {
		em.getTransaction().begin();
		TypedQuery<Long> query = em.createQuery("SELECT COUNT(*) FROM Admin  WHERE adminId = :id AND password = :pass", Long.class);
	    query.setParameter("id", id);
	    query.setParameter("pass", password);  
	    em.getTransaction().commit();
	    return query.getSingleResult() > 0;
		
	}

	@Override
	public void updateUser(UserTable utNew, int username) {
		em.getTransaction().begin();
		UserTable ut = em.find(UserTable.class, username);
		ut.setSecret_question(utNew.getSecret_question());
		ut.setLogin_password(utNew.getLogin_password());
		ut.setTransaction_password(utNew.getTransaction_password());
		em.merge(ut);
		em.getTransaction().commit();
		// TODO Auto-generated method stub
		
	}

	



}
