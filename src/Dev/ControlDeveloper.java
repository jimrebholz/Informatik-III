/**
 * Control De
 * 	Erzeugen von Test Commands
 * 	Test der verketteten Liste
 *  
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */
package Dev;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

public class ControlDeveloper {

	private String name = "Control-Developer";
	private ICommand[] commands = new ICommand[100];
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Erzeugen von Test Commands
	 */
	public void testCommands() {
		Direction d1 = new Direction();
		commands[0] = d1;
		d1.setDegree((int)(Math.random() * 90 -90));
		
		Gear g1 = new Gear();
		g1.setSpeed((int)(Math.random() * 100 -100));
		g1.setDuration((int)(Math.random() * 30 +0));
		commands[1] = g1;
		
		Pause p1 = new Pause();
		p1.setDuration((int)(Math.random() * 30 +0));
		commands[2] = p1;
	}
	
	/**
	 * Ausgabe aller Commands über das Array
	 */
	public void printCommands() {
		for (int i = 0; i < 3; i++) {
			System.out.println(commands[i].toString());
		}
	}

	/**
	 * Main zum Testen der Commmands
	 * 
	 * @param args Kommandozeilenparameter
	 */
	public static void main(String[] args) {
		
	ControlDeveloper c = new ControlDeveloper();
	
	System.out.println(c.name);
	//System.out.println(c.getName());
	System.out.println("");
	

	c.testCommands();
	System.out.println("Test Commands:");
	c.printCommands();
	System.out.println("");
	
	CommandList commandList = new CommandList();
	commandList.add(c.commands[0]);
	commandList.add(c.commands[1]);
	commandList.add(c.commands[2]);
	commandList.add(c.commands[0]);
	commandList.add(c.commands[1]);
	commandList.add(c.commands[2]);
	
	//System.out.println(commandList.get(1));

	//commandList.remove(2);
	commandList.moveUp(4);
	//commandList.moveDown(1);

	System.out.println("Ergebnisse aus verketteten Liste:");
	System.out.println(commandList.get(1));
	System.out.println(commandList.get(2));
	System.out.println(commandList.get(3));
	System.out.println(commandList.get(4));
	System.out.println(commandList.get(5));
	System.out.println(commandList.get(6));

	}
	
}
