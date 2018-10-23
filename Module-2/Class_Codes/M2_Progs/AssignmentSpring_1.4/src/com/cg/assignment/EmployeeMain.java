package com.cg.assignment;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain 
{
	static String empId=null;
	public static void main(String args[])
	{
		ApplicationContext factory = new ClassPathXmlApplicationContext("demo.xml");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id: ");
		int input = sc.nextInt();
		
		for(int i=0; i<=input; i++)
		{
			if(input==i)
			{
				try
				{
					empId="client"+i;
					Client clnt = (Client) factory.getBean(empId);
					System.out.println(clnt);
				}
				catch(Exception e)
				{
					System.out.println("No Record Found");
				}
			}
		}
	}
}
