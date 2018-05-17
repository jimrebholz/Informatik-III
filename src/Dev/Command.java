package Dev;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 * Command
 *  Oberklasse der Command Befehle, implementiert Interface ICommand aus controldeveloper
 *  
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */
public abstract class Command implements ICommand {

	private String name;
	
	/**
	 * @param name Name des Commands
	 */
	
	public Command(String name) {
		this.name = name;
	}

	/**
	 * Methode, die den Namen des Commands als String zurück gibt
	 * @return name Name des Commands
	 */
	public String getName() {
		return name;
	}

}
