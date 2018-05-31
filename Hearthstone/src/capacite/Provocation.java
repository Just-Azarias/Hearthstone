package capacite;

/**Cette classe représente la capacité provocation qui empêche l'attaque directe du héros
*
*@author Badr Matthieu
*/
public class Provocation extends Capacite {
	public Provocation(){
		super("Provocation", "Protege le heros et ses serviteurs des attaques");
	}
	
    public final void executerAction(Object cible) {}

    public final void executerEffetDebutTour() {}

    public final void executerEffetDisparition(Object cible) {
    }
	
	public final void executerEffetMiseEnJeu(Object cible) {}

    public final void executerEffetFinTour() {}
}