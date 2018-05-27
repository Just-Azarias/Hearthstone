package capacite;

/**Permet au serviteur d'attaquer directement
 * 
 * @author Badr Matthieu
 *
 */

public class Charge extends Capacite{
	public Charge() {
		super("Charge", "Permet au serviteur d'attaquer directement sans tour d'attente.");
	}
	
	public void executerAction(Object cible) {}
	
	public void executerEffetDebutTour() {}
	
	public void executerEffetDisparition(Object cible) {}
	
	public void executerEffetFinTour() {}
	
	public void executerEffetMiseEnJeu(Object cible) {}
}
