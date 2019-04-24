package MyCalculator;

import java.util.ArrayList;

import javax.swing.JButton;

public class Button {
	private JButton button;
	//private JPanel panel;
	private ArrayList<JButton> buttonList;
	private String[] operator = {"+", "-", "*", "/", ".", "=", "C"};	
	
	public Button() {
		this.button = new JButton();
		//this.panel = new JPanel(); 
		this.buttonList = new ArrayList<JButton>();
	}
	
	public ArrayList<JButton> getButton() {
		
		// button from 0-9
		for (int i = 0; i < 10; i++) {
			String str = Integer.toString(i);
			button = new JButton(str);
			//panel.add(button);
			buttonList.add(button);
			//button.addActionListener(new Listener());
		}
		
		// operator: + - * / = . C 
		for (String op: operator) {
			button = new JButton(op);
			//panel.add(button);
			buttonList.add(button);
			//button.addActionListener(new Listener());
		}
		
		return buttonList;


 	}
	
	
}
