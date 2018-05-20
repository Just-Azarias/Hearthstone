package Hearthstone.src.capacite

/**
*
*@author Badr Matthieu
*/
public abstract class Attaquer extends Capacite {
	protected int degat;
	
	public Attaquer(String nom, String description, int degat) {
		super(nom, description);
		this.degat=degat;
	}
}