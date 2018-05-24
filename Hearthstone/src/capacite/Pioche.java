package capacite;

/**Cette classe représente la pioche d'une ou plusieurs cartes
*
*@author Badr Matthieu
*/
public class Pioche extends Capacite {
	private int nb;
	
	public Pioche(int nb) {
		super("Pioche", "Vous piochez "+this.nb+" cartes.");
		setNb(nb);
	}
	
	private void setNb(int nb) {
		this.nb=nb;
	}
	
	public void executerAction(Object cible) throws HearthstoneException {
		if(cible == null)
			throw new HearthstoneException("Cible de pioche incorrecte");
		for(int k=0;k<this.nb;k++) {
			((IJoueur) cible).piocher();
		}
	}
	
	public final void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
        this.executerAction(cible);
    }
	
	public final void executerEffetDebutTour() {}

    public final void executerEffetFinTour() {}
	
	public final void executerEffetDisparition(Object cible) {}
}