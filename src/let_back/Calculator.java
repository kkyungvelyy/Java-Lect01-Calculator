package let_back;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Calculator extends JFrame {

	JPanel jpButton, jpResult;
	JLabel jlbResult1, jlbResult2;
	JButton[] jbButton = null;
	String[] numStr = { "←", "CE", "C", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "0", "00", ".",
			"=" }; 

	public Calculator() {
		getContentPane().setLayout(new BorderLayout());

		jpResult = new JPanel(new GridLayout(2, 1));
		jpResult.setBackground(Color.WHITE);
		jlbResult1 = new JLabel("", JLabel.RIGHT);
		jlbResult2 = new JLabel("0", JLabel.RIGHT); 

		jpResult.add(jlbResult1);
		jpResult.add(jlbResult2);

		jpButton = new JPanel(new GridLayout(5, 4, 5, 5)); 
		jpButton.setBackground(Color.WHITE); 
		jbButton = new JButton[numStr.length]; 

		for (int i = 0; i < numStr.length; i++) {
			jbButton[i] = new JButton(numStr[i]);
			jbButton[i].setFont(new Font("굴림", Font.BOLD, 20));
			jpButton.add(jbButton[i]);
			jbButton[i].addActionListener(new CalculatorListener());
		}
	}

	public static void main(String[] args) {
		new Calculator();
	}
}
