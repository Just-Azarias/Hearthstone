package Hearthstone.src.carte;

/**
*Cette classe définit une carte avec uniquement un sort étant une capacité
*@author Badr Matthieu
*/
public class Sort extends Carte {
	public Sort(String nom, int cout, IJoueur joueur, Capacite capacite) {
		super(nom, cout, joueur, capacite);
	}
	
	public boolean disparait(){ // a revoir car surement non utilisé
		return true;
	}
	
	public void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneExcepetion {
		if(this.getCout() > Plateau.getPlateau().getJoueurCourant().getStockMana())
			throw new HeathstoneException("Mana Insufisant");
		else {
			this.getCapacite().executerEffetMiseEnJeu(cible);
			Plateau.getPlateau().getJoueurCourant().getMain().remove(this);
		}
	}
	
	public void executerAction(Object cible) {}
	
	public void executeEffetDebutTour() {}
	
	public void executerEffetDisparition(Object cible) {}
	
	public void executerEffetFinTour() {}
	
	public String toString() {
		return "Sort " + super.toString();
	}
}