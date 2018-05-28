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
	private final int MAXDURATION = 10;

	public Gear() {

		super("Gear");

	}

	public Gear(int speed, double duration) {

		super("Gear");

		if (speed < -100)
			this.speed = -100;

		else if (speed > 100)
			this.speed = 100;

		else
			this.speed = speed;

		if (duration <= 0)
			this.duration = 0;

		else if (duration > MAXDURATION)
			this.duration = MAXDURATION;

		else
			this.duration = duration;

	}

	/**
	 * Methode, die den speed Wert als Int zurückgibt
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Methode, mit der man den speed Wert setzen kann
	 * @param speed (speed als Int Wert)
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
	 * Methode, die die duration in Sekunden als double ausgibt 
	 */
	
	public double getDuration() {
		return duration;
	}

	/**
	 * Methode, mit der man die duration setzen kann
	 * @param duration (duration als double in Sekunden)
	 */
	
	public void setDuration(double duration) {
		
		if (duration <= 0)
			this.duration = 0;

		else if (duration > 60)
			this.duration = 60;

		else
			this.duration = duration;

		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Der Wagen fährt mit " + speed + " % für " + duration + " Sekunden";
	}

}
