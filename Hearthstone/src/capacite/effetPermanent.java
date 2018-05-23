package Hearthstone.src.capacite;

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
	
	private void setAttaque(attaque){
		this.bonusAtq=attaque;
	}
	
	private void setPV(PV) {
		this.bonusPV=PV;
	}
	
	public int getBonusAtq() {
		return bonusAtq;
	}
	
	public int getBonusPV() {
		return bonusPV;
	}
	
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		for(ICarte carte : ((IJoueur) cible).getJeu()) {
			((Serviteur) carte).setAtq(((Serviteur) carte).getAtq() + bonusAtq);
			((Serviteur) carte).setPV(((Serviteur) carte).getPV() + bonusPV);
		}
	}
	
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		for(ICarte carte ; ((IJoueur) cible).getJeu()) {
			((Serviteur) carte).setAtq(((Serviteur) carte).getAtq() - bonusAtq);
			((Serviteur) carte).setPV(((Serviteur) carte).getPV() - bonusPV);
		}
	}
	
	public void executerEffetDebutTour() {}
	
	public void executerEffetFinTour() {}
	
	public void executerAction(Object cible){}
}