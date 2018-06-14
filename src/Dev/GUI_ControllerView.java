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
	private JButton button = new JButton("Add");
	private JTextField output = new JTextField(400);
	
	private JTextField textField1;
	private JTextField textField2;
	
	public GUI_ControllerView(ControlModel cM) {
		
		super("Control-Developer");
		this.cM = cM;
		this.setSize(600,400);
		this.setLayout(new BorderLayout());
		this.setMinimumSize(new Dimension(500, 300));
		this.setTitle("Control Devloper");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		GUI_MenuBar menu = new GUI_MenuBar(this);
		this.add(menu, BorderLayout.NORTH);
		
		GUI_Types types = new GUI_Types(cM, this);
		//this.add(types, BorderLayout.WEST);
		JScrollPane scrollPane = new JScrollPane();
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		this.add(scrollPane, BorderLayout.WEST);
		
		/*JPanel pane = new JPanel();
		pane.add(types, BorderLayout.CENTER);
		
		JPanel pane2 = new JPanel(new FlowLayout());
		pane2.add(button);
		pane.add(pane2, BorderLayout.SOUTH);
		
		this.add(pane, BorderLayout.WEST);
		*/
		this.revalidate();
		this.repaint();
		
		//JPanel panelList = new JPanel(new BorderLayout());
		//this.add(pane);
		
	  
	}
}

