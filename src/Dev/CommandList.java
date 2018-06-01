package Dev;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 *  CommandList -
 *  Implementierung einer Verkette Liste mit Methoden zum hinzufuegen, loeschen, anzeigen, 
 *  nach oben schieben, nach unten schieben.
 *  
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */


public class CommandList {


	
	private Element root = null;
	private int elementCounter = 0;
	
	/**
	 *  Element -
	 *  Die Anonyme Klasse Element wird fuer die Implementierung der verketteten Liste 
	 *  benoetigt
	 */
	private class Element {

		private Element next = null;
		private Element prev = null;
		private ICommand element = null;

		/**
		 * 
		 * @param command (Command als ICommand uebergeben)
		 */
		public Element(ICommand command) {
			this.element = command;
		}

		
		/**
		 * Methode, die den ICommand des jeweiligen Elements zurueckgibt
		 * @return element (ICommand)
		 */
		public ICommand getElement() {
			return element;
		}
	}

	/**
	 * Methode, die ein ICommand an die Liste anhaengt
	 * @param command (Ein command wird als ICommand uebergeben)
	 * @return boolean (true = erfolgreicher Prozess, false = error)
	 * 
	 */
	public boolean add(ICommand command) {

		//Hinzufügen des ersten Elements
		
		if (root == null) {
			root = new Element(command);
			root.next = null;
			root.prev = null;
			elementCounter++;
			return true;
		}

		//Hinzufügen irgendeines anderen Elements
		
		Element element = root;
		while (element.next != null)
			element = element.next;

		element.next = new Element(command);
		element.next.next = null;
		element.next.prev = element;
		elementCounter++;
		return true;

	}

	/**
	 * Methode, die ein gewuenschtes Element aus der Liste entfernt
	 * @param number (Gewuenschtes Listenelement als Int Wert)
	 * @return boolean (true = erfolgreicher Prozess, false = error)
	 */
	public boolean remove(int number) {
 
		// Kein Element in der Liste
		if (root == null)
			return false;

		// Erstes Element soll gelöscht werden
		else if (number == 1) {
			root = root.next;
			root.prev = null;
			elementCounter--;
			return true;
		}

		// Durchlaufen der Liste bis ein Objekt vor dem Remove Objekt
		Element element = root;

		for (int i = 1; i < number - 1; i++)
			element = element.next;

		// Letztes Element löschen
		if (number == elementCounter) {
			element.next = null;
			elementCounter--;
			return true;
		}

		// Irgendein Element mitten in der Liste löschen
		element.next = element.next.next;
		element.next.prev = element;
		elementCounter--;
		return true;

	}

	
	/**
	 * Methode, die das gewuenschte Listenelement zurueckgibt
	 * @param number (Gewuenschtes Listenelement als Int Wert)
	 * @return element (Rückgabe des jeweiligen Elements)
	 */
	public ICommand get(int number) {

		// Vorsichtsmaßnahmen
		if (number <= 0) {
			System.out.println("Fehler! ICommand konnte nicht übermittelt werden");
			return null;
		}

		else if (number == 1)
			return root.getElement();

		else if (number > elementCounter) {
			System.out.println("Es sind nicht so viele ICommands in der Liste");
			return null;
		}

		//Durchlaufen der Liste bis zum Gewünschten Element
		Element element = root;

		for (int i = 1; i < number; i++)
			element = element.next;

		return element.getElement();
	}
	
	/**
	 * Methode, die ein gewuenschtes Element in der Liste einen Platz nach vorne setzt
	 * @param number (Gewuenschtes Listenelement als Int Wert)
	 * @return boolean (true = erfolgreicher Prozess, false = error)
	 */
	public boolean moveUp(int number) {

		// Vorsichtsmaßnahmen
		if (elementCounter <= 1)
			return false;
		
		if (number <= 1)
			return false;

		else if (number > elementCounter)
			return false;

		// Durchlaufen der Liste bis zum Objekt, dass verschoben werden soll
		Element element = root;

		for (int i = 1; i < number; i++)
			element = element.next;

		// Zweites Element soll nach vorne verschoben werden
		if (number == 2) {

			Element tmp = root;

			remove(number);
			elementCounter++;

			root = element;
			element.next = tmp;
			element.prev = null;
			element.next.prev = element;
			return true;

		}

		// Irgendein Element soll nach vorne verschoben werden
		Element tmp = element.prev.prev;
		Element tmp1 = element.prev;

		remove(number);
		elementCounter++;

		tmp.next = element;
		tmp1.prev = element;
		element.prev = tmp;
		element.next = tmp1;
		return true;

	}

	/**
	 * Methode, die ein gewuenschtes Element in der Liste einen Platz nach hinten setzt
	 * @param number (Gewuenschtes Listenelement als Int Wert)
	 * @return boolean (true = erfolgreicher Prozess, false = error)
	 */
	public boolean moveDown(int number) {
		
		//TODO Nur ein Element in der Liste!

		Element element = root;

		// Vorsichtsmaßnahmen
		if (elementCounter <= 1)
			return false;
		
		if (number <= 0)
			return false;

		else if (number >= elementCounter)
			return false;

		// Erstes Element muss runter verschoben werden
		else if (number == 1) {

			remove(1);
			elementCounter++;

			Element tmp = root.next;

			root.next = element;
			element.prev = root;
			tmp.prev = element;
			element.next = tmp;
			return true;
		}

		// Durchlaufen der Liste bis zum Element, dass verschoben werden soll
		for (int i = 1; i < number; i++)
			element = element.next;

		// Vorletztes Element wird nach hinten verschoben
		if (number == (elementCounter - 1)) {
			remove(number);
			add(element.getElement());
			return true;
		}

		// Irgendein Element wird nach hinten verschoben
		Element tmp = element.next;
		Element tmp1 = element.next.next;

		remove(number);
		elementCounter++;

		tmp.next = element;
		element.prev = tmp;
		element.next = tmp1;
		tmp.prev = element;
		return true;

	}

	/**
	 * Methode, die ueberprueft, ob ein ICommand in der Liste gespeichert ist 
	 * @param command (ICommand, nach dem gesucht wird)
	 * @return boolean (true = vorhanden, false = nicht vorhanden)
	 */
	public boolean exist(ICommand command) {

		Element element = root;

		// Vergleichen ob es das erste Element ist
		if (element.getElement() == command)
			return true;

		// Liste durchlaufen und vergleichen
		for (int i = 1; i < elementCounter; i++) {

			if (element.getElement() == command)
				return true;

			element = element.next;
		}
		return false;

	}
	
	public int count() {
		return elementCounter;
	}

}
