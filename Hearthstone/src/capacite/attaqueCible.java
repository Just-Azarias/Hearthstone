package Hearthstone.src.capacite;
import carte.Serviteur;
import jeu.*;


/**
*Cette classe définit l'application de dégat sur une cible
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
			((Heros) cible).setPV(((Heros) cible).getPV()-degat);
		
		else
			((Serviteur) cible).setPV(((Serviteur) cible).getPV() - degat);
	}
	
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		this.executerAction(cible);
	}
	public void executerEffetDebutTour() {}
	
	public void executerEffetDisparition(Object cible){}
	
	public void executerEffetFinTour() {}
}