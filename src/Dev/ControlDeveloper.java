package Dev;

import javax.swing.JFrame;

import hsrt.mec.controldeveloper.core.com.command.ICommand;


/**
 * Control Developer
 * Erzeugen der ControllerView Benutzeroberfläche
 *  
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */

@SuppressWarnings("unused")
public class ControlDeveloper {

	private static String name = "Control-Developer";
	private ICommand[] commands = new ICommand[20];
	
	public static void main(String[] args){

		ControlDeveloper cD = new ControlDeveloper();
		GUI_ControllerView cV = new GUI_ControllerView(ControlModel.getInstance());
		cV.setVisible(true);
		
		
		///////////////////////////////////////////////////////////////////////////
		
		//ControlModel.getInstance().commandPerformed(new Direction());

		/*cD.testCommands();

		CommandList commandList = new CommandList();

		// ICommands werden der Liste hinzugefügt
		for (int i = 0; i < 6; i++)
			commandList.add(cD.commands[i]);

		// Ausgeben der verketteten Liste
		System.out.println("Ergebnis der Verketteten Liste");
		for (int i = 1; i < 7; i++)
			System.out.println(commandList.get(i));
		
		
		//Aufgabenblatt 2
		System.out.println("\nControl Process:");
		CommandList controlProcess = ControlModel.getInstance().getControlProcess();
		
		for (int i = 0; i < 3; i++)
			controlProcess.add(cD.commands[i]);
		
		Gear newCommand = (Gear) ControlModel.getInstance().getCommandTypes("Gear").createInstance();
		newCommand.setDuration(2);
		controlProcess.add(newCommand);
	
		*/
		//ControlModel.getInstance().save(ControlModel.file, false);
		//ControlModel.getInstance().load(ControlModel.file);
		
		///////////////////////////////////////////////////////////////////////////////
		
	}

	/**
	 * Methode, die den Namen des ControlDevelopers zurueckgibt
	 * @return name (name als String)
	 */
	
	public String getName() {
		return ControlDeveloper.name;
	}

	/**
	 * Methode, mit der man den Namen des ControlDevelopers setzen kann
	 * @param name (name als String)
	 */
	
	public void setName(String name) {
		ControlDeveloper.name = name;
	}

	/**
	 * Methode, die dazu dient ein paar zufällige ICommands zu erzeugen 
	 */
	public void testCommands() {

		Direction d1 = new Direction((int) (Math.random() * 181 - 90));
		Direction d2 = new Direction((int) (Math.random() * 181 - 90));
		Gear g1 = new Gear((int) (Math.random() * 201 - 100), Math.round((double) (Math.random() * 51 - 0)));
		Gear g2 = new Gear((int) (Math.random() * 201 - 100), Math.round((double) (Math.random() * 51 - 0)));
		Pause p1 = new Pause((int) (Math.random() * 51 - 0));
		Pause p2 = new Pause((int) (Math.random() * 51 - 0));

		commands[0] = d1;
		commands[1] = g1;
		commands[2] = p1;
		commands[3] = d2;
		commands[4] = g2;
		commands[5] = p2;

	}

	/**
	 * Methode, die die ICommands, die der ControlDeveloper gespeichert hat ausgibt!
	 */
	public void printCommands() {

		for (ICommand obj : commands) {
			if (obj != null)
				System.out.println(obj);
		}

		System.out.println("");

	}

}
