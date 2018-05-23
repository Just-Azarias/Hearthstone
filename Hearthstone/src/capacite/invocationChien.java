package Hearthstone.src.capacite;

/**Cette classe représente la capacité lacher les chiens
*
*@author Badr Matthieu
*/
public class InvocationChien extends InvocationServiteur {
	public InvocationChien(IJoueur joueur){
		super("Lacher les chiens", "Invoque un chien 1/1 avec la capacité charge pour chaque serviteur sur le terrain adverse",
		new Serviteur("Chien errant", 1, joueur, new Charge(), 1, 1), 0);
	}
	
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		this.nb=Plateau.getPlateau().getAdversaire((IJoueur) cible).getJeu().size();
		super.executerAction(cible);
	}
}
