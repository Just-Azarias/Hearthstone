package capacite;

import carte.Serviteur;
import jeu.HearthstoneException;
import jeu.ICarte;
import jeu.IJoueur;
import plateau.Plateau;

/**Cette classe représente la capacité lacher les chiens
*
*@author Badr Matthieu
*/
public class InvocationChien extends InvocationServiteur {
	public InvocationChien(IJoueur joueur) throws HearthstoneException{
		super("Lacher les chiens", "Invoque un chien 1/1 avec la capacite charge pour chaque serviteur sur le terrain adverse",
		new Serviteur("Chien errant", 1, joueur, new Charge(), 1, 1), 0);
	}
	
	public void executerEffetMiseEnJeu(Object carte) throws HearthstoneException {
		this.setNb( Plateau.getInstance().getAdversaire(((ICarte)carte).getProprietaire()).getJeu().size());
		super.executerAction(carte);
	}
}
