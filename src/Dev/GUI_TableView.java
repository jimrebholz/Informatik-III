package Dev;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import hsrt.mec.controldeveloper.core.com.ComHandler;
import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 * GUI_TableView
 * Erzeugen der Tabelle, um Commands graphisch darstellen zu können. 
 * Über die Tabelle können die Commands gelöscht, bearbeitet und verschoben werden.
 *  
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class GUI_TableView extends JTable{
	
	private CustomTableModel cTM = null;
	private JTable  table = new JTable();
	private JButton remove = new JButton("Remove");
	private JButton up = new JButton("Up");
	private JButton down = new JButton("Down");
	private JButton stop = new JButton("Stop");
	private JButton start = new JButton("Start");
	
	/**
	 * Konstruktor
	 * @param cM (ControlModel)
	 * @param frame (Frame)
	 * @param cTM (CustomTableModel)
	 */
	public GUI_TableView(ControlModel cM, JFrame frame, CustomTableModel cTM) {
		
		createTableView(cM, frame, cTM);
		
	}
	
	/**
	 * Erzeugen der TableView
	 * @param cM (ControlModel)
	 * @param frame (Frame)
	 * @param cTM (CustomTableModel)
	 */
	private void createTableView(ControlModel cM, JFrame frame, CustomTableModel cTM) {
		this.cTM = cTM;
		
		this.setLayout(new BorderLayout());
		
		table.setModel(this.cTM);	
		this.add(new JScrollPane(table), BorderLayout.CENTER);
		
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					String s = (String) table.getValueAt(table.getSelectedRow(), 1);
					new GUI_Dialogue(s, table.getSelectedRow() + 1, 1);

				}
			}
			
		});
		
		remove.addActionListener(new ActionListener() {
			
			public void actionPerformed (ActionEvent aE){
		    
				cTM.delRow(table.getSelectedRow());
				
			
			} 
		
		});
		
		up.addActionListener(new ActionListener() {
			
			public void actionPerformed (ActionEvent aE){
		    
				cTM.moveUpRow(table.getSelectedRow());
			} 
		
		});
		
		down.addActionListener(new ActionListener() {
			
			public void actionPerformed (ActionEvent aE){
		    
				cTM.moveDownRow(table.getSelectedRow());
			} 
		
		});
		
		start.addActionListener(new ActionListener() {
			
			public void actionPerformed (ActionEvent aE) {
				
				Vector<ICommand> commands = new Vector<ICommand>();
				for (int i = 1; i <= ControlModel.getInstance().getControlProcess().count(); i++) 
					commands.addElement(ControlModel.getInstance().getControlProcess().get(i));
				
				ComHandler.getInstance().start(commands, ControlModel.getInstance().getIOType());
			
			}
			
		});
		
		stop.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent aE) {
				
				ComHandler.getInstance().stop();
			}
		});
		
		
		table.getSelectedRow();
	}
	
	public JPanel getPanel() {
		
		JPanel typesPanel = new JPanel(new BorderLayout());
		typesPanel.add(this, BorderLayout.CENTER);
		
		JPanel typesPanel2 = new JPanel(new FlowLayout());
		typesPanel2.add(remove, BorderLayout.WEST);
		
		JPanel typesPanel3 = new JPanel(new FlowLayout());
		typesPanel3.add(up);
		typesPanel3.add(down);
		typesPanel3.add(stop);
		typesPanel3.add(start);
		
		JPanel listPanel4 = new JPanel(new BorderLayout());
		listPanel4.add(typesPanel2, BorderLayout.WEST);
		listPanel4.add(typesPanel3, BorderLayout.EAST);
		
		typesPanel.add(listPanel4, BorderLayout.SOUTH);
		
		return typesPanel;
	}

}
