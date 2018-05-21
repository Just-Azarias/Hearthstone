package capacite;

/**
*Cette classe définit la capacite d'attaquer un heros à travers toute défense
*@author Badr Matthieu
*/
public class AttaqueHeros extends Attaque {
	
	public AttaqueHeros(String nom, String description, int degat) {
		super(nom, description, degat);
	}
	
	public void executerAction(Object cible) throws HearthstoneException {
		if(this.isDisponible()==false)
			throw new HearthstoneException("Pouvoir héroïque utilisable 1 seul fois par tour !");
		else {
			this.setDisponible(false);
			if(cible instanceof IJoueur)
				cible=(Heros)
		}
	}
}