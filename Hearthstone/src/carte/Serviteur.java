package carte;

import capacite.Charge;
import capacite.Provocation;
import jeu.*;
import plateau.Plateau;

/**Cette classe représente un Serviteur
 * 
 * @author Badr Matthieu
 * 
 */
public class Serviteur extends Carte {
	public int peuJouer=0;   //nombre de fois que le serviteur peut attaquer
	public int pointDeVie=15;
	public int pointAttaque;

	public Serviteur(String nom, int cout, IJoueur proprietaire, ICapacite capacite, int attaque, int PV) throws HearthstoneException {
		super(nom, cout, proprietaire, capacite);
		setPointAttaque(attaque);
		setPointDeVie(PV);
	}
	
	public Serviteur(String nom, int cout, IJoueur proprietaire, int attaque, int PV) throws HearthstoneException {
		super(nom, cout, proprietaire, null);
		setPointAttaque(attaque);
		setPointDeVie(PV);
	}
	
	public Serviteur(Serviteur serviteur)throws HearthstoneException {
		super(serviteur.getNom(), serviteur.getCout(), serviteur.getProprietaire(), serviteur.getCapacite());
		setPointAttaque(serviteur.getPointAttaque());
		setPointDeVie(serviteur.getPointDeVie());
	}
	
	public void setPointAttaque(int attaque) throws HearthstoneException {
		if(attaque<0) throw new HearthstoneException("Attaque Incorrecte !");
		this.pointAttaque=attaque;
	}

	public void setPointDeVie(int PV) throws HearthstoneException {
		this.pointDeVie=PV;
	}
	
	private void setPeuJouer(int i) {
			this.peuJouer=i;
		}
	
	@Override
	public void executerEffetDebutTour(Object cible) throws HearthstoneException {
		this.peuJouer=1;
		this.getCapacite().executerEffetDebutTour();
	}

	@Override
	public void executerEffetFinTour(Object cible) throws HearthstoneException {
		if (this.getCapacite()!=null)
		this.getCapacite().executerEffetFinTour();
	}

	@Override
	public void executerEffetDebutMiseEnJeu(Object carte) throws HearthstoneException {
		if(this.getCapacite() instanceof Charge) this.peuJouer=1;
		this.getCapacite().executerEffetMiseEnJeu(carte);
		
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		if (this.getCapacite()!=null) 
			this.getCapacite().executerEffetDisparition(cible);
	}
		

	@Override
	public void executerAction(Object cible) throws HearthstoneException {
		if (cible == null) throw new HearthstoneException("Cible d'attaque invalide !");
		Plateau uniquePlateau = null;
		uniquePlateau = (Plateau) uniquePlateau.getInstance();
		IJoueur adversaire=uniquePlateau.getAdversaire(uniquePlateau.getJoueurCourant());
		if(cible instanceof Heros) {
			if(adversaire.isProvocation())
				throw new HearthstoneException("Serviteur avec provocation sur le terrain adverse !");
			else 
				((Heros) cible).setPointDeVie(((Heros) cible).getPointDeVie()-this.getPointAttaque());
		}
		else {
			if(cible instanceof Serviteur) {
				if(adversaire.isProvocation() && (!(((Serviteur) cible).getCapacite() instanceof Provocation)))
					throw new HearthstoneException("Serviteur avec provocation sur le terrain adverse !");
				else {
					((Serviteur) cible).setPointDeVie(((Serviteur) cible).getPointDeVie()-this.getPointAttaque());
					this.setPointDeVie(this.getPointDeVie()-((Serviteur) cible).getPointAttaque());
				}
			}
			else throw new HearthstoneException("Cible d'attaque incorrecte ! ");
		}
	}
	
	/**
	 * reroutne l'attaque du serviteur
	 * @return l'attaque du serviteur
	 */
	public int getPointAttaque() {
		return this.pointAttaque;
	}

	/**
	 * retourne si le serviteur peut attaquer
	 * @return true si le serviteur peut attaquer
	 */
	public int getPeuJouer(){
		return this.peuJouer;
	}
	
	@Override
	public boolean disparait() {
		return this.getPointDeVie()<=0;
	}

	/**
	 * Reduit le nombre d'attaque du serviteur de 1
	 */
	public void reduirePeuJouer() {
		this.peuJouer--;
	}

	/**
	 * Controle si le serviteur a possibilite d'attaquer
	 * @return true si il peut attaquer au moins encore 1 fois
	 */
	public boolean peutAttaquer() {
		if (this.getPeuJouer()<1) return false;
		return true;
	}
	
	/**
	 * retourne les points de vie du serviteur
	 * @return les points de vie
	 */
	public int getPointDeVie() {
		return this.pointDeVie;
	}

	public String toString() {
		String res;
		res= "\n##[[Serviteur] " +super.toString() + " --> ["+ getPointDeVie()+" PV / "+getPointAttaque()+" ATK]";
		if (this.getCapacite()!=null) res+= " --> "+this.getCapacite();
		res+="]";
		return res;
	}

	/**
	 * Augmente le nombre d'attaque disponible de 1
	 */
	public void AugmenterPeutJouer() {
		this.peuJouer+=1;
	}
}