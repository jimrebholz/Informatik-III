package Dev;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuListener;

import com.sun.glass.ui.MenuItem;

public class GUI_MenuBar extends JMenuBar{
	
	public GUI_MenuBar(JFrame frame) {
		
		//Erstellen einer Menüleiste
		JMenuBar menuBar = new JMenuBar();
		
		//Hinzufügen von Menüs
		JMenu menuFile = new JMenu("Datei");
		JMenu menuEdit = new JMenu("Bearbeiten");
		JMenu menuHelp = new JMenu("Hilfe");
		
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuHelp);
		
		JMenuItem beenden = new JMenuItem("Beenden");
		beenden.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		            System.exit(0);
		    }
		});
		
		menuFile.add(beenden);
		
		frame.setJMenuBar(menuBar);
		
	}
	

   
}
