package capacite;

import jeu.IJoueur;

/**
*
*@author Badr Matthieu
*/
public class CapaciteLepreux extends AttaqueHeros {
	public CapaciteLepreux() {
		super("Attaque ", "Rale d'agonie : Inflige 2 points de degat au heros adverse", 2);
	}
	
	public void executerEffetDisparition(IJoueur cible) throws HearthstoneException {
		super.executerAction(cible.getHeros());
	}
	
	public void executerEffetMiseEnJeu(Object cible){}
}