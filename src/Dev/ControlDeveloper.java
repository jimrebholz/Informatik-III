package Dev;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 * Control De Erzeugen von Test Commands Test der verketteten Liste
 * 
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */
public class ControlDeveloper {

	private static String name = "Control-Developer";
	private ICommand[] commands = new ICommand[100];

	/**
	 * 
	 * @return name des ControlDevelopers
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            Name des Commands
	 */
	public void setName(String name) {
		ControlDeveloper.name = name;
	}

	/**
	 * Erzeugen von Test Commands
	 */
	public void testCommands() {
		Direction d1 = new Direction();
		commands[0] = d1;
		d1.setDegree((int)(Math.random() * 181 - 90));

		Gear g1 = new Gear();
		g1.setSpeed((int) (Math.random() * 201 - 100));
		g1.setDuration(Math.round((double)(Math.random() * 31 + 0)));
		commands[1] = g1;

		Pause p1 = new Pause();
		p1.setDuration(Math.round((double) (Math.random() * 30 + 0)));
		commands[2] = p1;
	}

	/**
	 * Ausgabe aller Commands über das Array
	 */
	public void printCommands() {
		for (int i = 0; i < 3; i++) {
			System.out.println(commands[i]);
		}
	}

	/**
	 * Main zum Testen der Commmands
	 * 
	 * @param args
	 *            Kommandozeilenparameter
	 */
	public static void main(String[] args) {

		ControlDeveloper c = new ControlDeveloper();

		System.out.println(name);
		// System.out.println(c.getName());
		System.out.println("");

		// Anlegen der Testcommands
		c.testCommands();
		System.out.println("Test Commands:");
		// Ausgabe der Testcommands
		c.printCommands();
		c.printCommands();
		System.out.println("");

		// Einfuegen der Commands in die Liste
		CommandList commandList = new CommandList();
		commandList.add(c.commands[0]);
		commandList.add(c.commands[1]);
		commandList.add(c.commands[2]);
		commandList.add(c.commands[0]);
		commandList.add(c.commands[1]);
		commandList.add(c.commands[2]);

		// Funktionen der Liste
		//if (!commandList.remove(2))
		// 	System.out.println("Fehlerhafter Vorgang... Bitte versuchen Sie es erneut");
		if (!commandList.moveUp(6))
			System.out.println("Fehlerhafter Vorgang... Bitte versuchen Sie es erneut");
		if (!commandList.moveDown(2))
			System.out.println("Fehlerhafter Vorgang... Bitte versuchen Sie es erneut");

		System.out.println("Ergebnisse aus verketteten Liste:");
		System.out.println(commandList.get(1));
		System.out.println(commandList.get(2));
		System.out.println(commandList.get(3));
		System.out.println(commandList.get(4));
		System.out.println(commandList.get(5));
		System.out.println(commandList.get(6));

		System.out.println("");

		// Ueberpruefen, ob sich in Element X in der Liste befindet
		if (commandList.exist(c.commands[2]))
			System.out.println("Command gefunden...");
		else
			System.out.println("Command nicht gefunden...");

	}

}
