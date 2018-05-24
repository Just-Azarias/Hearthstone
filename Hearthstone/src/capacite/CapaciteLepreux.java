package capacite;

/**
*
*@author Badr Matthieu
*/
public class CapaciteLepreux extends AttaqueHeros {
	public CapaciteLepreux() {
		super("Attaque du Matthieu", "Rale d'agonie : Inflige 2 points de dégat au héros adverse", 2);
	}
	
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		super.executerAction(Plateau.getPlateau().getAdversaire((IJoueur) cible).getHeros());
	}
	
	public void executerEffetMiseEnJeu(Object cible){}
}