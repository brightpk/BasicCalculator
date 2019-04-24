package MyCalculator;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class GuiWindow extends JFrame {
	private JPanel panel; 
	private Calculator cal;
	private ArrayList<JButton> buttonList;
	private final JFrame frame;
	public static JTextField textField;
	private final String title = "Calculator";

	
	public GuiWindow() throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
		panel = new JPanel();
		//add(panel, BorderLayout.CENTER);
		frame = new JFrame(title);
		frame.setTitle("Calculator");
		frame.setSize(275, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textField = new JTextField(21);
		textField.setEditable(false);
		textField.setHorizontalAlignment(JTextField.RIGHT);
		textField.setDisabledTextColor(Color.BLACK);
		textField.setBackground(Color.WHITE);
	
		cal = new Calculator(textField);

		buttonList = new ArrayList<JButton>(); 	
	}
	
	public void setButton(Button b) {
		panel.add(textField);
		buttonList = b.getButton();
		
		for (JButton button: buttonList) {
			button.addActionListener(cal);
			panel.add(button);//, BorderLayout.WEST);
		}
		
		frame.add(panel);
		frame.setVisible(true); 
	
	}

 
}
