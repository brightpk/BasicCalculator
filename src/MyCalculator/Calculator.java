package MyCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import MyCalculator.Interfaces.ICalculate;
import MyCalculator.Interfaces.IPrevious;
import MyCalculator.view.DifferenceOperator;
import MyCalculator.view.DivisionOperator;
import MyCalculator.view.PreviousNumber;
import MyCalculator.view.ProductOperator;
import MyCalculator.view.SumOperator;

public class Calculator implements ActionListener {
	private final JTextField txt; 
	private Double curr = 0.0, prev = 0.0;
	private Double result = 0.0;
	private String operator;
	private ICalculate cal;
	private IPrevious prevNum;
	
	public Calculator(JTextField txt) {
		this.txt = txt;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();

		if (txt.getText().equals(Double.toString(prev))) {
			txt.setText("");
		}

		// Numbers or decimal button
		if (s.matches("[0-9]") || s.matches("[.]")) {
			try {
				txt.setText(txt.getText() + s);
				curr = Double.parseDouble(txt.getText());
				System.out.println("curr: " + curr);
			} catch (NumberFormatException ex) {
				ex.getMessage();
			}

			
		// Clear button
		} else if (s.equals("C")) {
			txt.setText("");
			curr = 0.0; prev = 0.0; result = 0.0;
			System.out.println("prev = " + curr + " curr = " + prev + " result = " + result);
			
		// Addition
		} else if (s.equals("+")) {
			System.out.println("---------Sum--------");
			operator = s;
			cal = new SumOperator();
			prevNum = new PreviousNumber(txt, cal);
			prev = prevNum.getPrevious(result, prev, curr);
			
			txt.setText(Double.toString(prev));
			
			System.out.println("prev: " + prev);
			System.out.println("---------------------");	
		
		// Subtraction
		} else if (s.equals("-")) {
			System.out.println("------Difference-----");
			operator = s;
			cal = new DifferenceOperator();
			prevNum = new PreviousNumber(txt, cal);
			prev = prevNum.getPrevious(result, prev, curr);
			
			txt.setText(Double.toString(prev));
			
			System.out.println("prev: " + prev);
			System.out.println("---------------------");
		
		// Multiplication
		} else if (s.equals("*")) {
			System.out.println("------Product-----");
			operator = s;
			cal = new ProductOperator();
			prevNum = new PreviousNumber(txt, cal);
			prev = prevNum.getPrevious(result, prev, curr);
			
			txt.setText(Double.toString(prev));
			
			System.out.println("prev: " + prev);
			System.out.println("---------------------");
		
		// Division
		} else if (s.equals("/")) {
			System.out.println("-------Division------");
			operator = s;
			cal = new DivisionOperator();
			prevNum = new PreviousNumber(txt, cal);
			prev = prevNum.getPrevious(result, prev, curr);
			
			txt.setText(Double.toString(prev));
			
			System.out.println("prev: " + prev);
			System.out.println("---------------------");
		
		// Equal
		} else if (s.equals("=")) {	
			result = cal.calculate(prev, curr);
			txt.setText(Double.toString(result));
			System.out.println(prev + " " + operator + " " + curr + " = " + result);
		}
		
		
	}

}
