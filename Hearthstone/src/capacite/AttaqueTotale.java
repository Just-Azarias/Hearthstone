package capacite;

import carte.Serviteur;
import jeu.HearthstoneException;
import jeu.ICarte;
import jeu.IJoueur;
import plateau.Plateau;

/**
*Cette classe définit des dégats globaux sur le plateau adverse
*@author Badr Matthieu
*/
public class AttaqueTotale extends Attaquer {
	
	public AttaqueTotale(String nom, String description, int degat) {
		super(nom, description, degat);
	}
	
	public void executerAction(Object cible)throws HearthstoneException { //c pas une putain de cible 
		if(cible instanceof IJoueur) {
			for(ICarte carte : Plateau.getInstance().getAdversaire((IJoueur) cible).getJeu())
				((Serviteur) carte).setPointDeVie(((Serviteur) carte).getPointDeVie() - getDegat());
		}
		else 
			throw new HearthstoneException("Cible entrée incorrecte !");
	}
	
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		this.executerAction(cible);
	}
	
	public void executerEffetDebutTour() {}
	
	public void executerEffetDisparition(Object cible) {}
	
	public void executerEffetFinTour() {}
}