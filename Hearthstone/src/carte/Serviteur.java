package carte;

import jeu.*;

/**
 * 
 * @author JustStrato&Aazarias
 *
 */
public class Serviteur extends Carte {
	public int enAttente=0;

	public Serviteur(String nom, int cout, IJoueur proprietaire, ICapacite capacite, String type) {
		super(nom, cout, proprietaire, capacite, type);
		// TODO Auto-generated constructor stub
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
	
}
