/**
 * CommandList
 *  Implementierung einer Verkette Liste mit Methoden zum hinzufügen, löschen, anzeigen, 
 *  nach oben schieben, nach unten schieben.
 *  
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */
package Dev;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

public class CommandList {

	private Element root;
	
	/**
	 * Hinzufügen eines Commands
	 */
	public boolean add(ICommand command) {
		if (root == null) {
			root = new Element(command);
			return true;
		}
		
		else if(root != null) {
			Element element = root;
			while (element.next != null) 
				element = element.next;
			
			element.next = new Element(command);
			return true;
		} 
		
		else 
			return false;
	}
	
	/**
	 * Löschen eines Commands
	 */
	public boolean remove(int number) {
		Element element = root;
		for(int i = 0; i < number - 2; i++)
			element = element.next;
		
		if (number == 1) 
			root = root.next;
	
		else 
			element.next = element.next.next;
		
		return true;
	}
	
	/**
	 * Ausgabe eines Commands
	 */
	public ICommand get(int number) {
		Element getCommand = root;
		for (int i = 0; i < number - 1; i++) 
			getCommand = getCommand.next;
		
		return getCommand.getElement();
	}
	
	/**
	 * Command in der Liste nach oben schieben
	 */
	public boolean moveUp(int number) {
		if (number == 1)
			return true;
		
		Element move = root;
		for (int i = 0; i < number - 1; i++) 
			move = move.next;
		
		if (number == 2) {
			Element element = new Element(move.element);
			remove(2);
			Element tmp = root;
			root = element;
			root.next = tmp;
			return true;
		}
		
		else {
			remove(number);
		
			Element element  = root;
				for (int i = 0; i < number - 3; i++) 
					element = element.next;
		
				Element tmp = element.next;
				element.next = new Element(move.getElement());
				element.next.next = tmp;
				return true;
		}
	}
	
	/**
	 * Command in der Liste nach unten schieben
	 */
	public boolean moveDown(int number) {
		Element move = root;
		for (int i = 0; i < number - 1; i++) 
			move = move.next;
		
		Element tmp = move.next.next;
		move.next.next = new Element(move.getElement());
		move.next.next.next = tmp;
		remove(number);
		return true;
	}
}
