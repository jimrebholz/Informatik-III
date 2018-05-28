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

	
	public Direction() {
	
		super("Direction");
		
	}
	
	public Direction(int degree) {

		super("Direction");

		if (degree < -90)
			this.degree = -90;

		else if (degree > 90)
			this.degree = 90;

		else
			this.degree = degree;
	}

	/**
	 * Methode, die den degree Wert zurückgibt
	 * @return degree (degree als Int Wert)
	 */
	
	public int getDegree() {
		return degree;
	}

	/**
	 * Methode, mit der man den degree Wert setzen kann
	 * @param degree (degree als Int Wert)
	 */
	
	public void setDegree(int degree) {
		
		if (degree < -90)
			this.degree = -90;

		else if (degree > 90)
			this.degree = 90;

		else
			this.degree = degree;
		
	}


	@Override
	public String toString() {
		return "Rotation des Wagens um " + degree + " Grad";
	}

}
