package Dev;

import hsrt.mec.controldeveloper.core.com.command.IDirection;

/**
 * Direction
 *  Klasse aus Hierarchie Command, implementiert Interface IDirection aus controldeveloper
 * 		
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */
public class Direction extends Command implements IDirection {
	
	private int degree;

	Direction() {
		super("Direction");
	}
	
	/**
	 * 
	 * @param degree Uebergabe der Richtung
	 */
	public void setDegree(int degree) {
		if (degree < -90)
			this.degree = -90;
		else if (degree > 90)
			this.degree = 90;
		else
			this.degree = degree;
	}

	/**
	 * @return degree Rueckgabe der Richtung
	 */
	public int getDegree() {
		return degree;
	}

	@Override
	/**
	 * return String Rueckgabe des Consolentextes
	 */
	public String toString() {
		return "Rotation to " + degree + " degree...";
	}

}
