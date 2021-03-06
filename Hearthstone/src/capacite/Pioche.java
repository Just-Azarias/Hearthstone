package capacite;

import jeu.HearthstoneException;
import jeu.ICarte;
import jeu.IJoueur;

/**Cette classe represente la pioche d'une ou plusieurs cartes
*
*@author Badr Matthieu
*/
public class Pioche extends Capacite {
	private int nb;
	
	public Pioche(int nb) {
		super("Pioche", "Vous piochez "+nb+" cartes.");
		setNb(nb);
	}
	
	private void setNb(int nb) {
		this.nb=nb;
	}
	
	public void executerAction(Object cible) throws HearthstoneException {
		if(cible == null)
			throw new HearthstoneException("Cible de pioche incorrecte");
		for(int k=0;k<this.nb;k++) {
			((ICarte) cible).getProprietaire().piocher();
		}
	}
	
	public final void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
        this.executerAction(cible);
    }
	
	public final void executerEffetDebutTour() {}

    public final void executerEffetFinTour() {}
	
	public final void executerEffetDisparition(Object cible) {}
}