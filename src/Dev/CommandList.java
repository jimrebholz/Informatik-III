package Dev;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 * CommandList Implementierung einer Verkette Liste mit Methoden zum
 * hinzufuegen, loeschen, anzeigen, nach oben schieben, nach unten schieben.
 * 
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */
public class CommandList {

	private Element root = null;
	private int count = 0;

	/**
	 * Element Innere annonyme Klasse zur Strukturierung der Liste
	 * 
	 */
	private class Element {

		private Element next;
		private Element previous;
		private ICommand element;

		/**
		 * 
		 * @param command
		 *            Command als ICommand uebergeben
		 */
		Element(ICommand command) {
			element = command;
		}

		/**
		 * 
		 * @return element Command wird zurueckgegeben
		 */
		public ICommand getElement() {
			return element;
		}
	}

	/**
	 * Hinzufügen eines Commands
	 * 
	 * @param command
	 *            Command als ICommand uebergeben
	 * @return true = erfolgreicher Prozess; false = fehlerhafter Prozess
	 */
	public boolean add(ICommand command) {
		// Erstes Element einfuegen
		if (root == null) {
			root = new Element(command);
			root.previous = null;
			root.next = null;
			count++;
			return true;
		}
		// Jedes andere Element einfuegen
		Element element = root;
		while (element.next != null)
			element = element.next;

		element.next = new Element(command);
		element.next.next = null;
		element.next.previous = element;
		count++;
		return true;
	}

	/**
	 * Löschen eines Commands
	 * 
	 * @param number
	 *            Gewuenschtes Listenelement als int
	 * @return true = erfolgreicher Prozess; false = fehlerhafter Prozess
	 */
	public boolean remove(int number) {
		// Ist noch kein Element vorhanden
		if (root == null)
			return false;

		// Loeschen des ersten Elements
		else if (number == 1) {
			root = root.next;
			root.previous = null;
			count--;
			return true;
		}

		Element element = root;
		for (int i = 0; i < number - 2; i++)
			element = element.next;

		// Sonderfall für letztes Element
		if (number == count) {
			element.next = null;
			count--;
			return true;
		}
		// Jedes andere Element loeschen
		element.next = element.next.next;
		element.next.previous = element;
		count--;
		return true;
	}

	/**
	 * Ausgabe eines Commands
	 * 
	 * @param number Gewuenschtes Listenelement als int
	 * @return element Rueckgabe des gesuchten Elements
	 */
	public ICommand get(int number) {

		// Fehlerbehandlung fuer ungueltige Zahl
		if (number < 1) {
			System.out.println("Fehler, bitte geben Sie eine gültige Zahl ein");
			return null;
		}

		// Sonderfall erstes Element ausgeben
		else if (number == 1)
			return root.getElement();

		// Fehlerbehandlung fuer ungueltige Zahl
		else if (number > count) {
			System.out.println("Fehler, bitte geben Sie eine gültige Zahl ein");
			return null;
		}

		// Jedes andere Element ausgeben
		Element getCommand = root;
		for (int i = 0; i < number - 1; i++)
			getCommand = getCommand.next;

		return getCommand.getElement();
	}

	/**
	 * Command in der Liste nach oben schieben
	 * 
	 * @param number
	 *            Gewuenschtes Listenelement als int
	 * @return true = erfolgreicher Prozess; false = fehlerhafter Prozess
	 */
	public boolean moveUp(int number) {
		// Fehlerbehandlung fuer ungueltige Zahl
		if (number <= 1)
			return false;

		// Fehlerbehandlung fuer ungueltige Zahl
		else if (count <= 1)
			return false;

		// Fehlerbehandlung fuer ungueltige Zahl
		else if (number > count)
			return false;

		Element element = root;
		for (int i = 0; i < number - 1; i++)
			element = element.next;

		// Sonderfall zweites Element nach oben schieben
		if (number == 2) {
			remove(2);
			count++;

			Element tmp = root;
			root = element;
			root.next = tmp;
			root.previous = null;
			root.next.previous = element;
			return true;
		}

		// Jedes andere Element nach oben schieben
		remove(number);
		count++;

		Element tmp = element.previous.previous;
		Element tmp2 = element.previous;

		tmp.next = element;
		tmp2.previous = element;
		element.previous = tmp;
		element.next = tmp2;
		return true;
	}

	/**
	 * Command in der Liste nach unten schieben
	 * 
	 * @param number
	 *            Gewuenschtes Listenelement als int
	 * @return true = erfolgreicher Prozess; false = fehlerhafter Prozess
	 */
	public boolean moveDown(int number) {
		Element element = root;
		// Fehlerbehandlung fuer ungueltige Zahl
		if (number < 1)
			return false;
		
		else if (count <= 1) 
			return false;
		
		// Sonderfall erstes Element nach unten schieben
		else if (number == 1) {
			remove(1);
			count++;

			Element tmp = root.next;
			root.next = element;
			element.previous = root;
			element.next = tmp;
			tmp.previous = element;
			return true;
		}
		// Fehlerbehandlung fuer ungueltige Zahl
		else if (number >= count)
			return false;

		for (int i = 0; i < number - 1; i++)
			element = element.next;

		// Sonderfall vorletztes Element
		if (number == count - 1) {
			remove(number);
			add(element.element);
			return true;
		}

		// Jedes andere Element nach unten schieben
		Element tmp = element.next;
		Element tmp2 = element.next.next;

		remove(number);
		count++;

		tmp.next = element;
		element.previous = tmp;
		element.next = tmp2;
		tmp2.previous = element;
		return true;
	}

	/**
	 * Überprüfen, ob sich der Command in der Liste befindet
	 * 
	 * @param command
	 *            Command als ICommand uebergeben
	 * @return true = erfolgreicher Prozess; false = fehlerhafter Prozess
	 */
	public boolean exist(ICommand command) {
		Element element = root;

		// Sonderfall gesuchtes Element = root
		if (command == root.element)
			return true;

		// Jedes andere Element in der Liste suchen
		for (int i = 0; i < count - 1; i++) {
			if (command == element.element)
				return true;
			element = element.next;
		}
		return false;
	}
}