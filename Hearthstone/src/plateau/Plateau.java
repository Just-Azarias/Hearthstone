package plateau;

import jeu.*;
import joueur.*;

public class Plateau implements IPlateau {
	private IJoueur joueur1;
	private IJoueur joueur2;
	private boolean tourJoueur1;
	private boolean tourJoueur2;
	private boolean partie;

	public Plateau(IJoueur joueur1, IJoueur joueur2) throws HearthstoneException {
		ajouterJoueur(joueur1);
		ajouterJoueur(joueur2);
		this.partie=false;
		this.tourJoueur1=true;
		this.tourJoueur2=false;
		
	}
	
	@Override
    public void ajouterJoueur(IJoueur joueur) throws HearthstoneException{
		if (joueur==null)  new HearthstoneException("Joueur non creer");
		if (this.joueur1==null) this.joueur1=joueur;
		else if (this.joueur2==null) this.joueur2=joueur;
		else new HearthstoneException("Joueurs deja enregistre");
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
		/*if (joueur.equals(this.joueur1)) {
			this.joueur2.getHeros().
		}
		else if (joueur.equals(this.joueur2)) {
			this.tourJoueur1=true;
			this.tourJoueur2=false;
		}
		else new HearthstoneException("joueur inexistant");*/
	}

}
