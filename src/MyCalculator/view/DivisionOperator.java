package MyCalculator.view;

import MyCalculator.Interfaces.ICalculate;

public class DivisionOperator implements ICalculate {

	@Override
	public Double calculate(Double num1, Double num2) {
		Double res = num1 / num2;
		System.out.println("num1 / num2 = " + res);
		return res;
	}

}
