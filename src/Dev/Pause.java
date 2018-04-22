/**
 * Pause
 * 	Klasse aus Hierarchie Command, implementiert Interface IPause aus controldeveloper
 *  
 * @author Marco Arena, Jim Rebholz
 * 
 * @version 1.0
 */
package Dev;

import hsrt.mec.controldeveloper.core.com.command.IPause;

public class Pause extends Command implements IPause {

	private double duration;
	
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	public double getDuration() {
		return duration;
	}
	 
	public String toString() {
		return duration + "s pause...";
	}
}
