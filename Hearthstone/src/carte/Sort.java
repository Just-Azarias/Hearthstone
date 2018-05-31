package carte;

import jeu.*;
import plateau.Plateau;

/**
*Cette classe définit une carte avec uniquement un sort étant une capacité
*@author Badr Matthieu
*/
public class Sort extends Carte {
	public Sort(String nom, int cout, IJoueur joueur, ICapacite capacite) {
		super(nom, cout, joueur, capacite);
	}

	public boolean disparait(){ // a revoir car surement non utilisee
		return true;
	}
	
	public void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException {
		this.getCapacite().executerAction(cible);
	}
	
	
	public void executerAction(Object cible) {}
	
	public void executeEffetDebutTour() {}
	
	public void executerEffetDisparition(Object cible) {}
	
	public void executerEffetFinTour() {}
	
	public String toString() {
		String res;
		res= "\n##[[Sort] " +super.toString();
		if (this.getCapacite()!=null) res+= " --> "+this.getCapacite();
		res+="]";
		return res;
	}

	@Override
	public void executerEffetDebutTour(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetFinTour(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}
}
