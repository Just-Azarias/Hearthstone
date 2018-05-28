package capacite;

import carte.Serviteur;
import jeu.HearthstoneException;
import jeu.IJoueur;

/**Cette classe represente la capacite du golem des moissons
*
*@author Badr Matthieu
*/
public class Golemisation extends InvocationServiteur {
	public Golemisation(IJoueur joueur) throws HearthstoneException{
		super("Golemisation", "Invoque un golem endomage 2/1", new Serviteur("Golem endomagee", 1, joueur, 2, 1), 1);
	}
	
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		super.executerAction(cible);
	}
	
	//L'effet ne doit s'activer qu'a la disparition
	public void executerEffetMiseEnJeu(Object cible) {}
}