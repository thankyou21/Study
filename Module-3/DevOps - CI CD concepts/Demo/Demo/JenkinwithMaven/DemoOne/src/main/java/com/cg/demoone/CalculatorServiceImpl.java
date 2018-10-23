package com.cg.demoone;


public class CalculatorServiceImpl implements ICalculatorService{

	@Override
	public double addition(double numOne, double numTwo) {
		// TODO Auto-generated method stub
		return numOne+numTwo;
	}

	@Override
	public double subTraction(double numOne, double numTwo) {
		// TODO Auto-generated method stub
		return numTwo-numOne;
	}

	@Override
	public double mulTiplication(double numOne, double numTwo) {
		// TODO Auto-generated method stub
		return numOne*numTwo;
	}

	@Override
	public double division(double numOne, double numTwo) {
		// TODO Auto-generated method stub
		return numOne/numTwo;
	}

}
