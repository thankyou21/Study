package com.cg.demo.ui;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

import com.cg.demo.entities.Mobile;

public class MobileQueryMain 
{
	public static void main(String args[])
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		
		String query= "select m from Mobile m where m.quantity>:qty";
		TypedQuery<Mobile> jpql = em.createQuery(query, Mobile.class);
		//TypedQuery<Mobile> jpql = em.createNamedQuery("getMobiles", Mobile.class);
		jpql.setParameter("qty",5);
		List<Mobile> mobileList = jpql.getResultList();
		for(Mobile m:mobileList)
			System.out.println(m);
	}
}
