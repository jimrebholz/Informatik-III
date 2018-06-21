package Dev;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import hsrt.mec.controldeveloper.core.com.WiFiCard;
import hsrt.mec.controldeveloper.core.com.WiFiCardHandler;
import hsrt.mec.controldeveloper.io.WiFi;


/**
 * GUI_MenuBar
 * Erzeugen der MenuBar mit den 3 Reitern File, Config und Help mit den jeweiligen Untermenüs
 *  
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class GUI_MenuBar extends JMenuBar{
	
	/**
	 * Konstruktor
	 * @param frame (Frame)
	 * @param cTM (CustomTableModel)
	 */
	public GUI_MenuBar(JFrame frame, CustomTableModel cTM) {
		
		createMenuBar(frame, cTM);
		
	}
	
	/**
	 * Erzeugen der MenuBar
	 * @param frame (Frame)
	 * @param cTM (CustomTableModel)
	 */
	private void createMenuBar(JFrame frame, CustomTableModel cTM) {
		
		//Erstellen einer Menüleiste
		JMenuBar menuBar = new JMenuBar();
		
		//Hinzufügen von Menüs
		JMenu menuFile = new JMenu("File");
		JMenu menuConfig = new JMenu("Configuration");
		JMenu menuHelp = new JMenu("Help");
		
		menuBar.add(menuFile);
		menuBar.add(menuConfig);
		menuBar.add(menuHelp);
		
		JMenuItem load = new JMenuItem("Load");
		JMenuItem save = new JMenuItem("Save");
		
		JMenuItem wifi = new JMenuItem("Connect to Wifi");
		
		JMenuItem helpMe = new JMenuItem("Give me some help");
		
		menuHelp.add(helpMe);
		
		JMenuItem close = new JMenuItem("Close");
		save.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		            System.exit(0);
		    }
		});
		
		
		menuFile.add(load);
		menuFile.add(save);
		menuFile.add(close);
		
		menuConfig.add(wifi);
		
		load.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	            	JFileChooser fileChooser = new JFileChooser();
	                int returnValue = fileChooser.showOpenDialog(null);
	                if (returnValue == JFileChooser.APPROVE_OPTION) {
	                  File selectedFile = fileChooser.getSelectedFile();
	                  ControlModel.getInstance().load(selectedFile);
	                  cTM.fireTableDataChanged();
	                }
	               
	            }
	        });
		
		save.addActionListener(new ActionListener() {
            @Override	
            public void actionPerformed(ActionEvent e) {
    				
    				JFileChooser fileChooser = new JFileChooser();
    				fileChooser.setCurrentDirectory(new File("/Users/Marco/Desktop"));
    				int retval = fileChooser.showSaveDialog(null);
    				
    				if(retval == JFileChooser.APPROVE_OPTION) {
    					File file = fileChooser.getSelectedFile();
    					if(file == null) {
    						return;
    					}
    					if(!file.getName().toLowerCase().endsWith(".txt")) 
    						file = new File(file.getParentFile(), file.getName() + ".txt");
    						
    					else
    						file = new File(file.getParentFile(), file.getName());
    					
    					ControlModel.getInstance().save(file, false);
    				}
    				
    		
    			}
    			
    		});
		
			wifi.addActionListener(new ActionListener() {
				@Override	
				public void actionPerformed(ActionEvent e) {
    				
					WiFiCardHandler wCH = new WiFiCardHandler();
					WiFiCard[] wifiCard = wCH.getWiFiCards();
					
					StringBuilder sb = new StringBuilder();
					
					InetAddress ip;
					try {
							
						ip = InetAddress.getLocalHost();
						System.out.println("Current IP address : " + ip.getHostAddress());
						
						NetworkInterface network = NetworkInterface.getByInetAddress(ip);
							
						byte[] mac = network.getHardwareAddress();
							
						System.out.print("Current MAC address : ");
							
						
						for (int i = 0; i < mac.length; i++) {
							sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
						}
						System.out.println(sb.toString());
							
					} catch (UnknownHostException e1) {
						
						e1.printStackTrace();
						
					} catch (SocketException e2){
							
						e2.printStackTrace();
							
					}
					    
				  
					WiFi wifi = new WiFi(wifiCard[0]);
					
					ControlModel.getInstance().setIOType(wifi);
					
					//System.out.println(wifiCard[0]);
				
				}
    			
    		});
			
			helpMe.addActionListener( new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					try { 
				         String url = "https://giphy.com/gifs/programming-pxwVj2Sk5JlMA/fullscreen";
				         Desktop.getDesktop().browse(URI.create(url));
				       }
				       catch (IOException e1) {
				           System.out.println(e1.getMessage());
				       }
				}
			});
		
		frame.setJMenuBar(menuBar);
	}
	
   
}
