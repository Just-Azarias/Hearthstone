package jeu;

public class Plateau implements IPlateau {
	private IJoueur joueur1;
	private IJoueur joueur2;
	private boolean tourJoueur1;
	private boolean tourJoueur2;
	private boolean partie;

	@Override
	public void ajouterJoueur(IJoueur joueur) throws HearthstoneException {
		// TODO Auto-generated method stub

	}

	@Override
	public IJoueur getJoueurCourant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setJoueurCourant(IJoueur joueur) throws HearthstoneException {
		// TODO Auto-generated method stub

	}

	@Override
	public IJoueur getAdversaire(IJoueur joueur) throws HearthstoneException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void demarrerPartie() throws HearthstoneException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean estDemarree() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void finTour(IJoueur joueur) throws HearthstoneException {
		// TODO Auto-generated method stub

	}

	@Override
	public void gagnePartie(IJoueur joueur) throws HearthstoneException {
		// TODO Auto-generated method stub

	}

}
