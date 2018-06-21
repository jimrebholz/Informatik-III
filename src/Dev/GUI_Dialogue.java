package Dev;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class GUI_Dialogue{
	
	GUI_Dialogue(String value, int row, int mode) {
	
		createDialogue(value, row, mode);
		
	}
	
	private void createDialogue(String value, int row, int mode) {
		
		JFrame dialogue = new JFrame(value);
		dialogue.setLayout(new BorderLayout());
		dialogue.setSize(new Dimension(250, 150));
		dialogue.setResizable(false);
		dialogue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//dialogue.setLocation((frame.getX() - 350) + frame.getWidth(), (frame.getY() + 100));
		dialogue.setLocationRelativeTo(null);
		dialogue.setVisible(true);
		
		
		JButton cancel = new JButton("Cancel");
		JButton save = new JButton("Save");
		
		if(value == "Direction") {
			
			JLabel degree = new JLabel(" Degree: ");
			JTextField degreeText = new JTextField(10);
			
			degreeText.setText("0");
			
			JPanel panelDegree = new JPanel(new FlowLayout());
			panelDegree.add(degree);
			panelDegree.add(degreeText);
			
			JPanel panelLS = new JPanel(new FlowLayout());
			panelLS.add(cancel);
			panelLS.add(save);
			
			JPanel panelLS2 = new JPanel(new BorderLayout());
			panelLS2.add(panelLS, BorderLayout.EAST);
		
			JPanel finalPanel = new JPanel(new BorderLayout());
			
			finalPanel.add(panelLS2, BorderLayout.SOUTH);
			finalPanel.add(panelDegree, BorderLayout.WEST);
			finalPanel.setBorder(BorderFactory.createTitledBorder("Configuration"));
		
			dialogue.add(finalPanel);
			
			if (mode == 1) {
				cancel.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent aE) {
			
						dialogue.dispose();
					}
					
				});
			}
			
			else {
				cancel.addActionListener(new ActionListener() {
				
					public void actionPerformed(ActionEvent aE) {
					
						CommandList controlProcess = ControlModel.getInstance().getControlProcess();
						controlProcess.remove(row);
						dialogue.dispose();
					}
				
				});
			}
			
			save.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					CommandList controlProcess = ControlModel.getInstance().getControlProcess();
					Direction direction = (Direction) controlProcess.get(row);		
					int degreeInt = Integer.parseInt(degreeText.getText());
					
					direction.setDegree(degreeInt);
					dialogue.dispose();
					
				}
			});
		}
		
		else if(value == "Gear") {
			
			JLabel speed = new JLabel(" Speed: ");
			JTextField speedText = new JTextField(10);
			
			speedText.setText("0");
			
			JLabel duration = new JLabel(" Duration: ");
			JTextField durationText = new JTextField(10);
			
			durationText.setText("0");
			
			JPanel panelSpeed = new JPanel(new BorderLayout());
			panelSpeed.add(speed, BorderLayout.WEST);
			panelSpeed.add(speedText, BorderLayout.EAST);
			
			JPanel panelDuration = new JPanel(new BorderLayout());
			panelDuration.add(duration, BorderLayout.WEST);
			panelDuration.add(durationText, BorderLayout.EAST);
			
			JPanel panel = new JPanel(new GridLayout(2, 1));
			panel.add(panelSpeed);
			panel.add(panelDuration);
			
			JPanel panelLS = new JPanel(new FlowLayout());
			panelLS.add(cancel);
			panelLS.add(save);
			
			JPanel panelLS2 = new JPanel(new BorderLayout());
			panelLS2.add(panelLS, BorderLayout.EAST);
		
			JPanel finalPanel = new JPanel(new BorderLayout());
			
			finalPanel.add(panelLS2, BorderLayout.SOUTH);
			finalPanel.add(panel, BorderLayout.WEST);
			finalPanel.setBorder(BorderFactory.createTitledBorder("Configuration"));
		
			dialogue.add(finalPanel);
			
			if (mode == 1) {
				cancel.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent aE) {
			
						dialogue.dispose();
					}
					
				});
			}
			
			else {
				cancel.addActionListener(new ActionListener() {
				
					public void actionPerformed(ActionEvent e) {
					
						CommandList controlProcess = ControlModel.getInstance().getControlProcess();
						controlProcess.remove(row);
						dialogue.dispose();
					}
				
				});
			}
			save.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					CommandList controlProcess = ControlModel.getInstance().getControlProcess();
					Gear gear = (Gear) controlProcess.get(row);		
					int speedInt = Integer.parseInt(speedText.getText());
					
					gear.setSpeed(speedInt);
							
					double durationDouble = Double.parseDouble(durationText.getText());
					
					gear.setDuration(durationDouble);
					dialogue.dispose();

				}
			});
		}
		
		else if(value == "Pause") {
			
			JLabel duration = new JLabel(" Duration: ");
			JTextField durationText = new JTextField(10);
			
			durationText.setText("0");
			
			JPanel panelDegree = new JPanel(new FlowLayout());
			panelDegree.add(duration);
			panelDegree.add(durationText);
			
			JPanel panelLS = new JPanel(new FlowLayout());
			panelLS.add(cancel);
			panelLS.add(save);
			
			JPanel panelLS2 = new JPanel(new BorderLayout());
			panelLS2.add(panelLS, BorderLayout.EAST);
		
			JPanel finalPanel = new JPanel(new BorderLayout());
			
			finalPanel.add(panelLS2, BorderLayout.SOUTH);
			finalPanel.add(panelDegree, BorderLayout.WEST);
			finalPanel.setBorder(BorderFactory.createTitledBorder("Configuration"));
		
			dialogue.add(finalPanel);
			
			if (mode == 1) {
				cancel.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent aE) {
			
						dialogue.dispose();
					}
					
				});
			}
			
			else {
			
				cancel.addActionListener(new ActionListener () {
				
					public void actionPerformed(ActionEvent e) {
					
						CommandList controlProcess = ControlModel.getInstance().getControlProcess();
						controlProcess.remove(row);
						dialogue.dispose();
					
					} 
				
				});
			
			}
			save.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					CommandList controlProcess = ControlModel.getInstance().getControlProcess();
					Pause pause = (Pause) controlProcess.get(row);		
					double pauseDouble = Double.parseDouble(durationText.getText());
					
					pause.setDuration(pauseDouble);
					dialogue.dispose();

				}
			});
		}
			
	}

	
}
