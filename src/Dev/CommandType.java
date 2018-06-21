package Dev;

/**
 * CommandType
 * Erzeugt 3 CommandType Objekte. 
 * Über den Namen des Commands kann der entsprechende Command erzeugt werden.
 *  
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */

public class CommandType {

	private String name;
	private final static int MAX = 3;
	private static int counter = 0;
	
	/**
	 * Privater Konstruktor, da nur 3 CommandType Objekte erzeugt werden sollen
	 * @param name (Gear, Direction, Pause)
	 */
	private CommandType(String name) {
		
		this.name = name;
	}
	
	/**
	 * Gibt den Namen des erzeugten CommandType Objekts zurück
	 * @return name (Name des CommandsTypes)
	 */
	public String getName() {
		
		return name;
	}
	
	/**
	 * Methode zum Erzeugen der CommandType Objekte
	 * @return new CommandType (Neu erstelltes CommandType Objekt)
	 */
	public static CommandType createClass(String name) {
		
		if(counter < MAX) {
			counter ++;
			return new CommandType(name);
		}
		else {
			System.out.println("Es können keine CommandType Objekte mehr erstellt werden!");
			return null;
		}
			
	}
	
	/**
	 * Methode zum Erzeugen der Command Objekte
	 * @return new Command (Neu erstelltes Command Objekt)
	 */
	public Command createInstance() {
		
		if(name == "Direction")
			return new Direction();
		
		if(name == "Gear")
			return new Gear();
		
		if(name == "Pause")
			return new Pause();
		
		return null;
		
	}
	
	
}
