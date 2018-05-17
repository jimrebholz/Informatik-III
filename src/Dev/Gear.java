package Dev;

import hsrt.mec.controldeveloper.core.com.command.IGear;

/**
 * Gear
 *  Klasse aus Hierarchie Command, implementiert Interface IGear aus controldeveloper
 * 		
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */
public class Gear extends Command implements IGear {

	private int speed;
	private double duration;

	Gear() {
		super("Gear");
	}

	/**
	 * 
	 * @param speed Uebergabe der Geschwindigkeit
	 */
	public void setSpeed(int speed) {
		if (speed < -100)
			this.speed = -100;
		else if (speed > 100)
			this.speed = 100;
		else
			this.speed = speed;
	}

	/**
	 * 
	 * @return speed Rueckgabe der Geschwindigkeit
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * 
	 * @param duration Uebergabe der Zeitdauer
	 */
	public void setDuration(double duration) {
		if (duration < 0)
			this.duration = 1;
		else if (duration > 30)
			this.duration = 30;
		else
			this.duration = duration;
	}
	
	/**
	 * 
	 * @return duration Rueckgabe der Zeitdauer
	 */
	public double getDuration() {
		return duration;
	}

	@Override
	/**
	 * return String Rueckgabe des Consolentextes
	 */
	public String toString() {
		return "Speed to " + speed + "% for the next " + duration + "s...";
	}

}
