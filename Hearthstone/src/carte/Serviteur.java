package carte;

import capacite.Charge;
import capacite.Provocation;
import jeu.*;
import joueur.Joueur;
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
		if(PV<=0) throw new HearthstoneException("Point de vie incorrecte !");
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
		this.getCapacite().executerEffetFinTour();
	}

	@Override
	public void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException {
		if(this.getCapacite() instanceof Charge) this.peuJouer=1;
		this.getCapacite().executerEffetMiseEnJeu(cible);
		
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
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
	
	public int getPointAttaque() {
		return this.pointAttaque;
	}

	public int getPeuJouer(){
		return this.peuJouer;
	}
	
	@Override
	public boolean disparait() {
		return this.getPointDeVie()<=0;
	}

	public void reduirePeuJouer() {
		this.peuJouer--;
	}

	
	public boolean peutAttaquer() {
		if (this.getPeuJouer()<1) return false;
		return true;
	}
	
	public int getPointDeVie() {
		return this.pointDeVie;
	}

	public String toString() {
		String res;
		res= "\n##[[Serviteur] " +super.toString() + " --> "+ getPointDeVie()+" PV/ "+getPointAttaque();
		if (this.getCapacite()!=null) res+= "-->"+this.getCapacite();
		return res;
	}
}