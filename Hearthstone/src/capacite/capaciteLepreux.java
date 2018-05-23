package Hearthstone.src.capacite;

/**
*
*@author Badr Matthieu
*/
public class capaciteLepreux extends AttaqueHeros {
	public capaciteLepreux() {
		super("Attaque du Matthieu", "Rale d'agonie : Inflige 2 points de dégat au héros adverse", 2);
	}
	
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		super.executerAction(Plateau.getPlateau().getAdversaire((IJoueur) cible).getHeros());
	}
	
	public void executerEffetMiseEnJeu(Object cible){}
}