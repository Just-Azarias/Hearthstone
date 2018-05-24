package capacite;

/**
*
*@author Badr Matthieu
*/
public class ImageMiroir extends InvocationServiteur {
	public ImageMiroir() {
		super("Image Miroir", "Invoque 2 serviteurs 0/2 avec la capacité Provocation",
		new Serviteur("Image Rémanente", 1, Plateau.getPlateau().getJoueurCourant(), new Provocation(), 0, 2), 2);
	}
	
	public void executerEffetMiseEnJeu(Object cible) {
		super.executerAction(cible);
	}
}