package capacite;

import carte.Serviteur;
import jeu.HearthstoneException;
import jeu.ICarte;
import jeu.IJoueur;

/**Cette classe représente la capacité de modifier l'attaque et les PV d'autres serviteur
*
* @author Badr Matthieu
*/
public class EffetPermanent extends Capacite {
	private int bonusAtq;
	private int bonusPV;
	
	public EffetPermanent(String nom, String description, int attaque, int PV) {
		super(nom, description);
		setAttaque(attaque);
		setPV(PV);
	}
	
	private void setAttaque(int attaque){
		this.bonusAtq=attaque;
	}
	
	private void setPV(int PV) {
		this.bonusPV=PV;
	}
	
	public int getBonusAtq() {
		return bonusAtq;
	}
	
	public int getBonusPV() {
		return bonusPV;
	}
	
	public void executerEffetMiseEnJeu(Object carte) throws HearthstoneException {
		for(ICarte c : ((ICarte)carte).getProprietaire().getJeu()) {
			((Serviteur) c).setPointAttaque(((Serviteur) c).getPointAttaque() + bonusAtq);
			((Serviteur) c).setPointDeVie(((Serviteur) c).getPointDeVie() + bonusPV);
		}
	}
	
	public void executerEffetDisparition(Object carte) throws HearthstoneException {
		for(ICarte c : ((ICarte)carte).getProprietaire().getJeu()) {
			((Serviteur) c).setPointAttaque(((Serviteur) c).getPointAttaque() - bonusAtq);
			((Serviteur) c).setPointDeVie(((Serviteur) c).getPointDeVie() - bonusPV);
		}
	}
	
	public void executerEffetDebutTour() {}
	
	public void executerEffetFinTour() {}
	
	public void executerAction(Object cible){}
}