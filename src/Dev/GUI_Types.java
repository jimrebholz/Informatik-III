package Dev;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JViewport;


public class GUI_Types extends JScrollPane {

	private ControlModel cM = null;
	private JList<String> list = new JList<String>();
	
	public GUI_Types(ControlModel cM, JFrame frame) {
		this.cM = cM;
		
		JScrollPane scrollPane = new JScrollPane();
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		
		
		/*JScrollPane sP = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JLabel label = new JLabel("Types", JLabel.CENTER);
		JViewport header = new JViewport();
		
		header.setView(label);
		sP.setColumnHeader(header);
		
		sP.setViewportView(list);
		
		list.setListData(cM.getCommandTypes());
		list.setVisibleRowCount(3);
		this.add(sP);
		*/
	}
	
}
