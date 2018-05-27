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
	@Override
	public void executerAction(Object cible) throws HearthstoneException {
		if(cible ==null)
			throw new HearthstoneException("Cible NULL !");
		
		/*On controle si la cible est un Heros, sinon c'est (normalement) un serviteur*/
		if(cible instanceof Heros)
			((Heros) cible).setPointDeVie(((Heros) cible).getPointDeVie()-getDegat());
		
		else
			((Serviteur) cible).setPointDeVie(((Serviteur) cible).getPointDeVie()-getDegat());
	}
	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		this.executerAction(cible);
	}
	@Override
	public void executerEffetDebutTour() {}
	
	@Override
	public void executerEffetDisparition(Object cible){}
	
	@Override
	public void executerEffetFinTour() {}
}