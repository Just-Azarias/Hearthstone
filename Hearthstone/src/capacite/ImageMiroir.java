package capacite;

import jeu.HearthstoneException;

/**
*
*@author Badr Matthieu
*/
public class ImageMiroir extends InvocationServiteur {
	public ImageMiroir() {
		super("Image Miroir", "Invoque 2 serviteurs 0/2 avec la capacite Provocation", new Serviteur("Image Remanente", 1, Plateau.getPlateau().getJoueurCourant(), new Provocation(), 0, 2), 2);
	}
	
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		super.executerAction(cible);
	}
}