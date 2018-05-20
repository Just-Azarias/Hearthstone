package Hearthstone.src.capacite;

/**
*Cette classe définit des dégats globaux sur le plateau adverse
*@author Badr Matthieu
*/
public class AttaqueTotale extends Attaque {
	
	public AttaqueTotale(String nom, String description, int degat) {
		super(nom, description, degat);
	}
	
	public void executerAction(Object cible)throws HearthstoneException {
		if(cible instanceof IJoueur) {
			for(ICarte carte : Plateau.getPlateau().getAdversaire((IJoueur) cible).getJeu())
				((Serviteur) carte).setPV(((Serviteur) carte).getPV() - degat);
		}
		else 
			throw new HearthstoneException("Cible entrée incorrecte !");
	}
	
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneExcepetion {
		this.executerAction(cible);
	}
	
	public void executerEffetDebutTour() {}
	
	public void executerEffetDisparition(Object ciblé) {}
	
	public void executerEffetFinTour() {}
}