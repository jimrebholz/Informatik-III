/**
 * Gear
 *  Klasse aus Hierarchie Command, implementiert Interface IGear aus controldeveloper
 * 		
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */
package Dev;

import hsrt.mec.controldeveloper.core.com.command.IGear;

public class Gear extends Command implements IGear {

	private int speed; 
	private double duration;
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	public double getDuration() {
		return duration;
	}
	
	public String toString() {
		return "Speed to " + speed + "% for the next " + duration + "s...";
	}
	
	
}
