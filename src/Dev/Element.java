/**
 * Element
 *  Implementiert die Struktur eines Eintrags der verketteten Liste CommandList
 * 		
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */
package Dev;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

public class Element {

	Element next;
	Element previous;
	ICommand element;

	Element(ICommand command) {
		element = command;
	}
	
	public ICommand getElement() {
		return element;
	}
}

