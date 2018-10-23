package com.cg.capgemini.HelloWorld;

import org.junit.Assert;
import org.junit.Test;


public class CalculatorTest 
{
	@Test
	public void Test1()
	{
		Calculator cal = new Calculator();
		Assert.assertEquals(10,cal.add(4,6));
	}
	
	@Test
	public void Test2()
	{
		Calculator cal = new Calculator();
		Assert.assertEquals(2,cal.sub(8,6));
	}
}
