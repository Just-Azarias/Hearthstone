package plateau;

import java.util.ArrayList;

import jeu.*;
import joueur.*;

public class Plateau implements IPlateau {
	private ArrayList<IJoueur> joueurs = new ArrayList<IJoueur>();
	private static IPlateau uniquePlateau=null;
	private IJoueur joueurCourant = null;
	private boolean demaree = false;
	
	public static IPlateau getInstance() {
		if(uniquePlateau==null)
		uniquePlateau = new Plateau();
		return uniquePlateau;
	}
	
	@Override
    public void ajouterJoueur(IJoueur joueur) throws HearthstoneException{
		if (joueur==null)  new HearthstoneException("Joueur non creer");
		if (joueurs.size() == 2) throw new HearthstoneException("2 Joueurs deja enregistrees !");
		if (joueurs.contains(joueur)) new HearthstoneException("Joueur deja enregistre !");
		joueurs.add(joueur);
	}

	@Override
	public IJoueur getJoueurCourant() {
		if (this.tourJoueur1) return this.joueur1;
		else return this.joueur2;
	}

	@Override
	public void setJoueurCourant(IJoueur joueur) throws HearthstoneException {
		if (joueur.equals(this.joueur1)) {
			this.tourJoueur1=true;
			this.tourJoueur2=false;
		}
		else if (joueur.equals(this.joueur2)) {
			this.tourJoueur1=false;
			this.tourJoueur2=true;
		}
		else new HearthstoneException("joueur inexistant");
	}

	@Override
	public IJoueur getAdversaire(IJoueur joueur) throws HearthstoneException {
		if (joueur.equals(this.joueur1)) return this.joueur2;
		else if (joueur.equals(this.joueur2)) return this.joueur1;
		else new HearthstoneException("joueur inexistant");
		return null;
	}

	@Override
	public void demarrerPartie() throws HearthstoneException {
		this.partie=true;
	}

	@Override
	public boolean estDemarree() {
		return this.partie;
	}

	@Override
	public void finTour(IJoueur joueur) throws HearthstoneException {
		if (joueur.equals(this.joueur1)) {
			this.tourJoueur1=false;
			this.tourJoueur2=true;
		}
		else if (joueur.equals(this.joueur2)) {
			this.tourJoueur1=true;
			this.tourJoueur2=false;
		}
		else new HearthstoneException("joueur inexistant");
	}

	@Override
	public void gagnePartie(IJoueur joueur) throws HearthstoneException {
		if (getAdversaire(joueur).getHeros().getPointDeVie()==0) ; ///// a finir
	}

	public static Plateau getPlateau() {
		// TODO Auto-generated method stub
		return null;
	}

}
