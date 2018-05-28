package capacite;

import jeu.HearthstoneException;
import jeu.Heros;
import jeu.IJoueur;
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
		if (cible instanceof IJoueur) cible = (Heros) Plateau.getInstance().getAdversaire((IJoueur) cible).getHeros();
        if (!(cible instanceof Heros)) 
        	throw new HearthstoneException("La cible doit �tre un h�ros.");
        ((Heros) cible).setPointDeVie(((Heros) cible).getPointDeVie() - getDegat());
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