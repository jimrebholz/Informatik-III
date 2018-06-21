package Dev;

import hsrt.mec.controldeveloper.core.com.command.IPause;

/**
 * Pause
 * 	Klasse aus Hierarchie Command, implementiert Interface IPause aus controldeveloper
 *  
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */

public class Pause extends Command implements IPause {

	private double duration;

	public Pause() {
		
		super("Pause");
		
	}
	
	public Pause(double duration) {
		super("Pause");

		if (duration < 0)
			this.duration = 0.0;

		else if (duration > 60)
			this.duration = 60.0;

		else
			this.duration = duration;

	}

	/**
	 * Methode, die die duration zurueckgibt
	 * @ return duration (duration als Int Wert)
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * Methode, mit der man die duration in Sekunden setzen kann
	 * @param duration (duration in Sekunden als double)
	 */
	public void setDuration(double duration) {
		
		if (duration < 0)
			this.duration = 0;

		else if (duration > 60)
			this.duration = 60;

		else
			this.duration = duration;

		
	}

	@Override
	public String toString() {
		return "Pause" + SEPERATOR  + duration;
	}

}
