package Dev;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;


/**
 * GUI_Console
 * Erzeugen der Console Text Area im Frame
 * Über CommandPerformed des ComHandlers werden die momentan ausgeführten Befehle in die Console geladen
 *  
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */

public class GUI_Console{

	public static JTextArea console = new JTextArea();;
	
	/**
	 * Konstruktor
	 */
	public GUI_Console() {
		
		createConsole();
		
	}
	
	
	/**
	 * Erzeugen der Konsole
	 */
	private void createConsole() {
		
		console.setPreferredSize(new Dimension(700, 100));
		console.setEditable(false);
		
		console.setBorder(BorderFactory.createTitledBorder("Console"));
	}
	
	/**
	 * Ausgeben der Console
	 * @return console (Ausgeben der Console)
	 */
	public JTextArea nichtz() {
	
		return console;
	}
	
}
