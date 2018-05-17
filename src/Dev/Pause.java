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

	Pause() {
		super("Pause");
	}

	/**
	 * 
	 * @param duration Uebergabe der Zeitdauer
	 */
	public void setDuration(double duration) {
		if (duration < 0)
			this.duration = 0;
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
	 * @return String Rueckgabe des Consolentextes
	 */
	public String toString() {
		return duration + "s pause...";
	}
}
