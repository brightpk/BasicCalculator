package MyCalculator.view;

import javax.swing.JTextField;

import MyCalculator.Interfaces.ICalculate;
import MyCalculator.Interfaces.IPrevious;

public class PreviousNumber implements IPrevious {
	private JTextField txt;
	private ICalculate cal;
	
	public PreviousNumber(JTextField txt, ICalculate cal) {
		this.txt = txt;
		this.cal = cal;
	}

	@Override
	public Double getPrevious(Double result, Double prev, Double curr) {
		Double prevNum = 0.0;
		
		if (!result.equals(0.0)) {
			prevNum = result;
			
		} else if (result.equals(0.0) && prev.equals(0.0)) {
			String tmp = txt.getText();
			prevNum = Double.parseDouble(tmp);
			
		} else if (result.equals(0.0) && !prev.equals(0.0)) {
			prevNum = cal.calculate(prev, curr);
		}
		
		return prevNum;
	}

}
