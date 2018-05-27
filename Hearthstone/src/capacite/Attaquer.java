package capacite;

/**
*
*@author Badr Matthieu
*/
public abstract class Attaquer extends Capacite {
	private int degat;
	
	public Attaquer(String nom, String description, int degat) {
		super(nom, description);
		this.degat=degat;
	}
	
	public void setDegat(int attaque) {
		degat = attaque;
	}
	
	public int getDegat() {
		return this.degat;
	}
}