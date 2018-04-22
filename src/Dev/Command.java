/**
 * Command
 *  Oberklasse der Command Befehler, implementiert Interface ICommand aus controldeveloper
 *  
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */
package Dev;

//Einfügen des Command Interfaces aus controldeveloper
import hsrt.mec.controldeveloper.core.com.command.ICommand;

public abstract class Command implements ICommand {

	private String name;
	
	public String getName() {
		return name;
	}
	
}
