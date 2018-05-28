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
		/*On controle si on a assez de mana, et si oui, on utilise le sort
		et on la supprime directement après, à revoir si on utilise des cartes
		d'équipement*/
		if(this.getCout() > Plateau.getInstance().getJoueurCourant().getStockMana())
			throw new HearthstoneException("Mana Insufisant");
		else {
			this.getCapacite().executerEffetMiseEnJeu(cible);
			Plateau.getInstance().getJoueurCourant().getMain().remove(this);
		}
	}
	
	
	public void executerAction(Object cible) {}
	
	public void executeEffetDebutTour() {}
	
	public void executerEffetDisparition(Object cible) {}
	
	public void executerEffetFinTour() {}
	
	public String toString() {
		String res;
		res= "[Sort] " +super.toString();
		if (this.getCapacite()!=null) res+= " --> "+this.getCapacite();
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
