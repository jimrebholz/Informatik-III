package Dev;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

public class GUI_Types extends JList {

	private ControlModel cM = null;
	private JScrollPane sP = new JScrollPane();
	private JButton add = new JButton("Add");
	private JList<String> list = new JList<String>();

	
	public GUI_Types(ControlModel cM, JFrame frame, CustomTableModel cTM) {
		
		createTypes(cM, frame, cTM);
	}
	
	private void createTypes(ControlModel cM, JFrame frame, CustomTableModel cTM) {
		
		this.cM = cM;
		
		JLabel label = new JLabel("Types", JLabel.CENTER);
		JViewport header = new JViewport();
		
		header.setView(label);
		header.setBackground(new Color(211, 211, 211));
		sP.setColumnHeader(header);
		
		
		sP.setViewportView(list);
		
		list.setListData(cM.getCommandTypes());
		list.setFixedCellHeight(50);
		this.add(sP);
		
		add.setEnabled(false);
	
		list.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				add.setEnabled(true);  
				if(e.getClickCount() == 2) {
					
					cTM.addRow(list.getSelectedValue());
					new GUI_Dialogue(list.getSelectedValue(), ControlModel.getInstance().getControlProcess().count(), 0);
					System.out.println(list.getSelectedIndex()+1);
					add.setEnabled(false);
					
					
					
				}

			}
		});
		
		
		add.addActionListener(new ActionListener() {
			
			public void actionPerformed (ActionEvent aE){
		    
				if(aE.getSource() == add) {
					
					cTM.addRow(list.getSelectedValue());
				
					new GUI_Dialogue(list.getSelectedValue(), ControlModel.getInstance().getControlProcess().count(), 0);
					add.setEnabled(false);
					
				}	
			
			} 
		
		});
	}
	
	
	public JPanel getPanel() {
		
		JPanel typesPanel = new JPanel(new BorderLayout());
		typesPanel.add(sP, BorderLayout.CENTER);
		
		JPanel typesPanel2 = new JPanel(new FlowLayout());
		typesPanel2.add(add);
		
		JPanel typesPanel3 = new JPanel(new BorderLayout());
		typesPanel3.add(typesPanel2, BorderLayout.EAST);
		
		typesPanel.add(typesPanel3, BorderLayout.SOUTH);
		
		typesPanel.setPreferredSize(new Dimension(150, 400));
		this.add(typesPanel, BorderLayout.WEST);
		
		return typesPanel;
	}
	
	
}
