package capacite;

import jeu.HearthstoneException;
import jeu.Heros;
import plateau.Plateau;

/**
*Cette classe définit la capacite d'attaquer un heros à travers toute défense
*@author Badr Matthieu
*/
public class AttaqueHeros extends Attaquer {
	
	public AttaqueHeros(String nom, String description, int degat) {
		super(nom, description, degat);
	}
	
	public void executerAction(Object cible) throws HearthstoneException {
		Heros adversaire= ( Plateau.getInstance().getAdversaire( Plateau.getInstance().getJoueurCourant()).getHeros());
        (adversaire).setPointDeVie(adversaire.getPointDeVie() - this.getDegat());
	}

	@Override
	public void executerEffetDebutTour() throws HearthstoneException {	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {}

	@Override
	public void executerEffetFinTour() throws HearthstoneException {}

	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {}


}