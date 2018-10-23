package com.cg.assignment.ui;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.assignment.bean.Author;

public class AuthorMain 
{
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
	static EntityManager em = emf.createEntityManager();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String args[])
	{
		System.out.println("Welcome to the portal");
		int choice;
		while(true)
		{
			System.out.println("\n\n1>> Add Author\t2>>Find Author\t3>>Update Author\t4>>Delete Author\t5>>Exit\nChoose your operation:");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1: addAuthor(); break;
			case 2: findAuthor(); break;
			case 3: editAuthor(); break;
			case 4: removeAuthor(); break;
			case 5: System.out.println("\nThank you!");System.exit(0);
			default: System.out.println("Invalid choice! Try again..."); break;
			}
		}
	}
	
	public static void addAuthor()
	{
		//insert
		Author newAuthor = new Author();
		System.out.println("Enter Author First Name: ");
		newAuthor.setFirstName(sc.next());
		System.out.println("Enter Author Middle Name (In case No middle type 'x'):");
		newAuthor.setMiddleName(sc.next());
		System.out.println("Enter Author Last Name: ");
		newAuthor.setLastName(sc.next());
		System.out.println("Enter Author Phone No. ");
		newAuthor.setPhoneNo(sc.next());
		
		em.getTransaction().begin();
		em.persist(newAuthor);
		em.getTransaction().commit();
			
		System.out.println("1 row inserted.");
	}
	
	public static void findAuthor()
	{
		System.out.println("Enter Author ID:");
		Author findAuthor = em.find(Author.class,sc.nextInt());
		System.out.println(findAuthor);
	}
	
	public static void editAuthor()
	{
		System.out.println("Enter Author ID:");
		Author editAuthor = em.find(Author.class,sc.nextInt());
		
		System.out.println("Select:\n 1 to update First Name\n 2 to update Middle Name\n 3 to update Last Name\n 4 to update Contact Number");
		int choice = sc.nextInt();
		switch(choice)
		{
			case 1: System.out.println("Enter First Name"); editAuthor.setFirstName(sc.next()); break;
			case 2: System.out.println("Enter Middle Name"); editAuthor.setMiddleName(sc.next()); break;
			case 3: System.out.println("Enter Last Name"); editAuthor.setLastName(sc.next()); break;
			case 4: System.out.println("Enter Contact No."); editAuthor.setPhoneNo(sc.next()); break;
			default: System.out.println("Invalide Choice!");
		}
		
		em.getTransaction().begin();
		em.merge(editAuthor);
		em.getTransaction().commit();
		System.out.println("1 row updated.");
	}
	
	public static void removeAuthor()
	{
		System.out.println("Enter Author ID:");
		Author removeAuthor = em.find(Author.class,sc.nextInt());
		em.getTransaction().begin();
		em.remove(removeAuthor);
		em.getTransaction().commit();
			
		System.out.println("1 row deleted.");
	}
}
