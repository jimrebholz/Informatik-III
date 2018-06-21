package Dev;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI_Console{

	public static JTextArea console = new JTextArea();;
	
	public GUI_Console() {
		
		console.setPreferredSize(new Dimension(700, 100));
		console.setEditable(false);
		
		console.setBorder(BorderFactory.createTitledBorder("Console"));
	}
	
	public JTextArea getPanel() {
	
		return console;
	}
	
}
