package plateau;

import java.util.ArrayList;
import java.util.Random;

import jeu.HearthstoneException;
import jeu.IJoueur;
import jeu.IPlateau;


public class Plateau implements IPlateau {
	private ArrayList<IJoueur> joueurs = new ArrayList<IJoueur>();
	private static IPlateau uniquePlateau=null;
	private IJoueur joueurCourant = null;
	private boolean demarree = false;
	
	public static IPlateau getInstance() {
		if(uniquePlateau==null)
		uniquePlateau = new Plateau();
		return uniquePlateau;
	}
	
	@Override
    public void ajouterJoueur(IJoueur joueur) throws HearthstoneException{
		if (joueur==null) throw new HearthstoneException("Joueur non creer");
		if (joueurs.size() == 2) throw new HearthstoneException("2 Joueurs deja enregistrees !");
		if (joueurs.contains(joueur)) throw new HearthstoneException("Joueur deja enregistre !");
		joueurs.add(joueur);
	}

	@Override
	public IJoueur getJoueurCourant() {
		return this.joueurCourant;
	}

	@Override
	public void setJoueurCourant(IJoueur joueur) throws HearthstoneException {
		this.joueurCourant = joueur;
	}

	@Override
	public IJoueur getAdversaire(IJoueur joueur) throws HearthstoneException {
		if(joueur==null) throw new HearthstoneException("Joueur Incorrecte");
		if(!joueurs.contains(joueur)) throw new HearthstoneException("Le joueur n'est pas dans la partie !");
		return (this.getJoueurCourant() == joueurs.get(0)) ? this.joueurs.get(1) : this.joueurs.get(0);
	}

	@Override
	public void demarrerPartie() throws HearthstoneException {
		if(this.estDemarree()) throw new HearthstoneException("La Partie est en cours !");
		if(this.joueurs.size()!=2) throw new HearthstoneException("Nombre de joueurs Invalide !");
		this.demarree=true;
		this.setJoueurCourant(this.joueurs.get((new Random()).nextInt(2)));
		//for(int k=0;k<3;k++) {
			uniquePlateau.getJoueurCourant().prendreTour();
			//uniquePlateau.getAdversaire(uniquePlateau.getJoueurCourant()).piocher();
		//}
		//this.getJoueurCourant().prendreTour();
	}

	@Override
	public boolean estDemarree() {
		return this.demarree;
	}

	@Override
	public void finTour(IJoueur joueur) throws HearthstoneException {
		this.getJoueurCourant().finirTour();
		this.setJoueurCourant(this.getAdversaire(joueur));
		this.getJoueurCourant().prendreTour();
	}

	@Override
	public void gagnePartie(IJoueur joueur) throws HearthstoneException {
		if(joueur==null) throw new HearthstoneException("Joueur null !");
		if(uniquePlateau.getAdversaire(joueur).getHeros().getPointDeVie()>0) throw new HearthstoneException("Tentative de triche !");
		System.out.println(this.getJoueurCourant().getPseudo()+" a gagné la partie ! Bravo !");
		this.demarree=false;
	}
}
