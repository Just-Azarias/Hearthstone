package carte;

import jeu.*;

/**
 * 
 * @author JustStrato&Aazarias
 *
 */
public class Serviteur extends Carte {
	public int enAttente=0;
	public int pointDeVie=15;
	public int pointAttaque;

	public Serviteur(String nom, int cout, IJoueur proprietaire, ICapacite capacite, int attaque, int PV) {
		super(nom, cout, proprietaire, capacite);
		setPointAttaque(attaque);
		setPointDeVie(PV);
	}
	
	private void setPointAttaque(int attaque) {
		this.pointAttaque=attaque;
	}

	public void setPointDeVie(int PV) {
		this.PointDeVie=PV;
	}

	@Override
	public void executerEffetDebutTour(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetFinTour(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerAction(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	public int getAttente(){
		return this.enAttente;
	}
	
	@Override
	public boolean disparait() {
		// TODO Auto-generated method stub
		return false;
	}

	public void reduireAttente() {
		this.enAttente--;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getPointDeVie() {
		return this.PointDeVie;
	}
	
}
