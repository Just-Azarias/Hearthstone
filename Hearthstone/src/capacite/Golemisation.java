package capacite;

/**Cette classe représente la capacite du golem des moissons
*
*@author Badr Matthieu
*/
public class Golemisation extends InvocationServiteur {
	public Golemisation(IJoueur joueur) {
		super("Golemisation", "Invoque un golem endomage 2/1", new Serviteur("Golem endomagé", 1, joueur, null, 2, 1), 1);
	}
	
	public void executerEffetDisparition(Object cible) {
		super.executerAction(cible);
	}
	
	public void executerEffetMiseEnJeu(Object cible) {}
}