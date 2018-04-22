/**
 * Direction
 *  Klasse aus Hierarchie Command, implementiert Interface IDirection aus controldeveloper
 * 		
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */
package Dev;

import hsrt.mec.controldeveloper.core.com.command.IDirection;

public class Direction extends Command implements IDirection {

	private int degree;
	
	public void setDegree(int degree) {
		this.degree = degree;
	}
	
	public int getDegree() {
		return degree;
	}
	
	public String toString() {
		return "Rotation to " + degree + " degree...";
	}
	
}
