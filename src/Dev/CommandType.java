package Dev;

public class CommandType {

	private String name;
	private final static int MAX = 3;
	private static int counter = 0;

	
	private CommandType(String name) {
		
		this.name = name;
	}
	
	
	public String getName() {
		
		return name;
	}
	
	
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
