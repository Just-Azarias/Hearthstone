package capacite;

import carte.Serviteur;
import jeu.HearthstoneException;

/**Cette classe représente la capacité Marque du Chasseur
*
*@author Badr Matthieu
*/
public class MarqueChasseur extends AttaqueCible {
	
	public MarqueChasseur() {
		super("Marque du Chasseur", "Modifie les points de vie du serviteur cible a� 1", 0);
	}
	
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		super.executerEffetMiseEnJeu(cible);
		if(cible instanceof Serviteur)
			((Serviteur) cible).setPointDeVie(1);
		else
			throw new HearthstoneException("Erreur ! La cible n'est pas un serviteur !");
	}
}