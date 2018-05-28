package Dev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import hsrt.mec.controldeveloper.core.com.command.ICommand;


/**
 * Control Developer
 * 	Erzeugen von Test Commands
 * 	Test der verketteten Liste
 *  
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */

public class ControlDeveloper {

	private static String name = "Control-Developer";
	private ICommand[] commands = new ICommand[20];

	
	public static void main(String[] args){

		ControlDeveloper cD = new ControlDeveloper();

		// Aufgabe 1
		System.out.println(name);
		System.out.println(cD.getName());

		// Aufgabe 3
		cD.testCommands();
		cD.printCommands();

		CommandList commandList = new CommandList();

		// ICommands werden der Liste hinzugefügt
		for (int i = 0; i < 6; i++)
			commandList.add(cD.commands[i]);

		// Test der Funktion exist
		if (commandList.exist(cD.commands[1]))
			System.out.println("Obj vorhanden");
		else
			System.out.println("Obj nicht vorhanden");

		
		// Testen der Funktion moveUp/moveDown
		// commandList.moveUp(3);
		if(!commandList.moveDown(2))
			System.out.println("Der Vorgang ist gescheitert");
		else
			System.out.println("Der Vorgang war erfolgreich");
		

		
		// Ausgeben der verketteten Liste
		System.out.println("Ergebnis der Verketteten Liste");
		for (int i = 1; i < 7; i++)
			System.out.println(commandList.get(i));
		
		
		System.out.println("TEST");
		CommandType ct1 = CommandType.createClass("Direction");
		CommandType ct2 = CommandType.createClass("Gear");
		CommandType ct3 = CommandType.createClass("Pause");
		
		Direction d1 = (Direction) ct1.createInstance();
		System.out.println(d1);
		
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
		commands[1] = d2;
		commands[2] = g1;
		commands[3] = g2;
		commands[4] = p1;
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
