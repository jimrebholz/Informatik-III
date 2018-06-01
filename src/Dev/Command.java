package Dev;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 *  Command -
 *  Oberklasse der Command Befehle, implementiert Interface ICommand aus ControlDeveloper
 *  
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */
public abstract class Command implements ICommand {

	private String name;
	protected static final String SEPERATOR = ";";
	
	
	/**
	 * @param name (Name des Commands als String)
	 */
	public Command(String name) {
		this.name = name;
	}

	/**
	 * Methode, die den Namen des Commands als String zurueckgibt.
	 * @return name (Name des Commands als String)
	 */
	public String getName() {
		return this.name;
	}

	
}
