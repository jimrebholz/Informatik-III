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

@SuppressWarnings({ "unused", "serial" })
public class GUI_ControllerView extends JFrame{

	private ControlModel cM = null;
	private JTextField input = new JTextField(20);
	private JButton button = new JButton("Hinzufügen");
	private JTextField output = new JTextField(400);
	
	private JTextField textField1;
	private JTextField textField2;
	
	public GUI_ControllerView(ControlModel cM) {
		
		super("Control-Developer");
		createControllerView(cM);
	  
	}
	
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
		this.add(console.getPanel(), BorderLayout.SOUTH);
	
		GUI_TableView list = new GUI_TableView(cM, this, cTM);
		this.add(list.getPanel(), BorderLayout.CENTER);
		
		this.setResizable(false);

		
		//JPanel panelList = new JPanel(new BorderLayout());
		//this.add(pane);
		
	}
}

