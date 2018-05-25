package capacite;
import carte.Serviteur;
import jeu.*;


/**
*Cette classe definit l'application de degat sur une cible
*@author Badr Matthieu
*/
public class AttaqueCible extends Attaquer {
	
	public AttaqueCible(String nom, String description, int degat) {
		super( nom, description, degat);
	}
	
	public void executerAction(Object cible) throws HearthstoneException {
		if(cible ==null)
			throw new HearthstoneException("Cible NULL !");
		
		/*On controle si la cible est un Heros, sinon c'est (normalement) un serviteur*/
		if(cible instanceof Heros)
			((Heros) cible).setPointDeVie(((Heros) cible).getPointDeVie()-degat);
		
		else
			((Serviteur) cible).setPointDeVie(((Serviteur) cible).getPointDeVie()-degat);
	}
	
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		this.executerAction(cible);
	}
	public void executerEffetDebutTour() {}
	
	public void executerEffetDisparition(Object cible){}
	
	public void executerEffetFinTour() {}
}