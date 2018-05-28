package capacite;

import carte.Serviteur;
import jeu.HearthstoneException;
import jeu.IJoueur;

/**
*
*@author Badr Matthieu
*/
public class ImageMiroir extends InvocationServiteur {
	public ImageMiroir(IJoueur joueur) throws HearthstoneException {
		super("Image Miroir", "Invoque 2 serviteurs 0/2 avec la capacite Provocation", 
				new Serviteur("Image Remanente", 1, joueur, new Provocation(), 0, 2), 2);
	}
	
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		super.executerAction(cible);
	}
}