package capacite;

import java.util.ArrayList;

import carte.Serviteur;
import jeu.HearthstoneException;
import jeu.IJoueur;
import plateau.Plateau;

public class InvocationServiteur extends Capacite{
	private Serviteur serviteur;
	private int nb;
	
	public InvocationServiteur(String nom, String description, Serviteur serviteur, int nb) {
		super(nom, description);
		this.setServiteur(serviteur);
		this.setNb(nb);
	}
	
	public void executerAction(Object cible) throws HearthstoneException {
		//Plateau plateau=null;
		IJoueur courant=Plateau.getInstance().getJoueurCourant();
		int nombre=(courant.getJeu().size()+getNb() > courant.MAX_BOARD)? courant.MAX_BOARD-courant.getJeu().size() : getNb();
		for(int k=0; k<nombre; k++) {
			courant.getJeu().add(new Serviteur(getServiteur()));
		}
	}
	
	public void setServiteur(Serviteur serviteur) {
		this.serviteur=serviteur;
	}
	
	public Serviteur getServiteur() {
		return serviteur;
	}
	
	public void setNb(int nb) {
		this.nb = nb;
	}
	
	public int getNb() {
		return nb;
	}
	
	public void executerEffetDebutTour() {}
	
	public void executerEffetFinTour() {}
	
	public void executerEffetDisparition(Object cible) throws HearthstoneException{}
	
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
	this.executerAction(cible);	
	}
}
