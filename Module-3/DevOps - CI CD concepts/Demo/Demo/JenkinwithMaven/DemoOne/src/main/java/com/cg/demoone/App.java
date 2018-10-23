package com.cg.demoone;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Calling Calculator...." );
		ICalculatorService calculator=new CalculatorServiceImpl();
		System.out.println( "Addition of Two Number "+calculator.addition(10,20) );
		System.out.println( "Subtraction of Two Number "+calculator.subTraction(20,10) );
	System.out.println( "Multiplication of Two Number "+calculator.mulTiplication(20,2) );
		System.out.println( "Division of Two Number "+calculator.division(20,10) );
    }
}
