package Main;

import MyCalculator.Button;
import MyCalculator.GuiWindow;

public class Main {

	public static void main(String[] args) throws Exception {
		Button b = new Button();
		GuiWindow window = new GuiWindow();
		window.setButton(b);
	}
}
