package Dev;

import java.io.File;
import java.util.Vector;

import hsrt.mec.controldeveloper.core.com.ComHandler;
import hsrt.mec.controldeveloper.core.com.IComListener;
import hsrt.mec.controldeveloper.core.com.command.ICommand;
import hsrt.mec.controldeveloper.io.Console;
import hsrt.mec.controldeveloper.io.IOType;
import hsrt.mec.controldeveloper.io.TextFile;

/**
 * ControlModel
 * Zentralverwaltung der Liste und CommandTypes mit zusätzlichen Methoden zum Laden und Speichern von Daten
 *  
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */

public class ControlModel implements IComListener {

	private static ControlModel instance = null;
	private CommandType [] commandTypes = new CommandType[3];
	private CommandList controlProcess = null;
	private final String SEPERATOR = ";"; 
	private IOType ioType = null;
	//static File file = new File("//Users//jimrebholz//Desktop//test.txt");	
	
	/**
	 * Privater Konstruktor (Singleton)
	 */
	private ControlModel() {
		setControlProcess(new CommandList()); 
		createCommandTypes();
		ComHandler.getInstance().register(this);
	}

	/**
	 * Methode um den IOType Modus zu erfragen
	 * @return ioType (Gear, Direction, Pause)
	 */
	public void setIOType(IOType iOT) {
		this.ioType = iOT;
	}
	
	public IOType getIOType() {
		return ioType;
	}
	
	/**
	 * Gibt CommandTyp Objekt zurück
	 * @param name (Gear, Direction, Pause)
	 */
	public CommandType getCommandTypes(String name) {
		
		if(name == "Gear")
			return commandTypes[1];
		
		else if(name == "Direction")
			return commandTypes[0];
		
		else if(name == "Pause")
			return commandTypes[2];
		
		else 
			return null;
	}
	
public String[] getCommandTypes() {
		
		String[] str = new String[3];
		str[1] = "Gear";
		str[2] = "Pause";
		str[0] = "Direction";

		return str ;
	}
	
	
	public static ControlModel getInstance() {
		
		if(instance == null) 
			instance = new ControlModel();
		
		return instance;
		
	}
	
	public void createCommandTypes() {
		
		commandTypes [0] = CommandType.createClass("Direction");
		commandTypes [1] = CommandType.createClass("Gear");
		commandTypes [2] = CommandType.createClass("Pause");
		
	}


	public CommandList getControlProcess() {
		return controlProcess;
	}


	public void setControlProcess(CommandList controlProcess) {
		this.controlProcess = controlProcess;
	}
	
	
	public boolean load(File file) {
		
		TextFile txt = new TextFile(file, false);
		Console cmd = new Console();
		Vector<String> data = new Vector<String>();
	
		txt.read(data);
		txt.close();
		
		controlProcess = new CommandList();
		
		String[] parts = new String[3];
		
		for(String tmp : data) {
			
			parts = tmp.split(SEPERATOR);
			
			if(parts[0].equals("Direction")) {
				Direction newCommand = (Direction) commandTypes[0].createInstance();
				newCommand.setDegree(Integer.decode(parts[1]));
				controlProcess.add(newCommand);
			}
			
			else if(parts[0].equals("Gear")) {
				Gear newCommand = (Gear) commandTypes[1].createInstance();
				newCommand.setSpeed(Integer.decode(parts[1]));
				newCommand.setDuration(Double.parseDouble((parts[2])));
				controlProcess.add(newCommand);
			}
			
			else if(parts[0].equals("Pause")) {
				Pause newCommand = (Pause) commandTypes[2].createInstance();
				newCommand.setDuration(Double.parseDouble((parts[1])));
				controlProcess.add(newCommand);
			}
			
		}
		
		cmd.write(data);
		
		return true;
	}
	
	public boolean save(File file, boolean append) {
		
		TextFile txt = new TextFile(file, append);
		Console cmd = new Console();
		Vector<String> data = new Vector<String>();
		
		
		for (int i = 0; i < controlProcess.count(); i++) 
			data.add(i, controlProcess.get(i + 1).toString());

		txt.write(data);
		txt.close();
		cmd.write(data);
		
		return true;
	}


	@Override
	public void commandPerformed(ICommand arg0) {
		
		String s = arg0.getName();
		
		if(s.equals("Direction")) {
			GUI_Console.console.setText(" Processing Command:\n > " + ((Direction) arg0).getDegree() + " Degree...");
		}
		else if(s.equals("Gear")) {
			GUI_Console.console.setText(" Processing Command:\n > " + s + ((Gear) arg0).getSpeed() 
										+ " cm/sec " + ((Gear) arg0).getDuration() + " sec");
		}
		
		else if(s.equals("Pause")) {
			GUI_Console.console.setText(" Processing Command:\n > " + s + ((Pause) arg0).getDuration() + " sec...");
		}
		
	}
	
}

