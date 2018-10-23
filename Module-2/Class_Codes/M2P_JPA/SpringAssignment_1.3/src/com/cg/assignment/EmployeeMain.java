package com.cg.assignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain 
{
	public static void main(String args[])
	{
		ApplicationContext factory = new ClassPathXmlApplicationContext("demo.xml");
		SBU sbu = factory.getBean(SBU.class);
		System.out.println(sbu);
	}
}
