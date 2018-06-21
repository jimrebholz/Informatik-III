package Dev;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * GUI_ControllerView
 * Erzeugen der einzelnen Komponenten für den Frame
 *  
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */

@SuppressWarnings({ "unused", "serial" })
public class GUI_ControllerView extends JFrame{

	private ControlModel cM = null;
	
	
	/**
	 * Konstruktor
	 * @param cM (Übergabe des ControlModels)
	 */
	public GUI_ControllerView(ControlModel cM) {
		
		super("Control-Developer");
		createControllerView(cM);
	  
	}
	/**
	 * Erzeugen der ControllerView
	 * @param cM (Übergabe des ConrolModels)
	 */
	private void createControllerView(ControlModel cM) {
		
		this.cM = cM;
		this.setLayout(new BorderLayout());
		this.setSize(new Dimension(600, 500));
		this.setTitle("Control Devloper");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	
		CustomTableModel cTM = new CustomTableModel();
		
		GUI_MenuBar menu = new GUI_MenuBar(this, cTM);
		this.add(menu, BorderLayout.NORTH);
		
		GUI_Types types = new GUI_Types(cM, this, cTM);
		this.add(types.getPanel(), BorderLayout.WEST);
		
		GUI_Console console = new GUI_Console();
		this.add(console.nichtz(), BorderLayout.SOUTH);
	
		GUI_TableView list = new GUI_TableView(cM, this, cTM);
		this.add(list.getPanel(), BorderLayout.CENTER);
		
		this.setResizable(false);
	}
}

