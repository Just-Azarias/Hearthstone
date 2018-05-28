package capacite;

import jeu.HearthstoneException;
import jeu.IJoueur;

/**
*Cette classe définit la capacite d'attaquer un heros à travers toute défense
*@author Badr Matthieu
*/
public class AttaqueHeros extends Attaquer {
	
	public AttaqueHeros(String nom, String description, int degat) {
		super(nom, description, degat);
	}
	
	public void executerAction(Object cible) throws HearthstoneException {
		if(!(cible instance))
		if(this.isDisponible()==false)
			throw new HearthstoneException("Pouvoir heroique utilisable 1 seul fois par tour !");
		else {
			this.setDisponible(false);
			if(cible instanceof IJoueur)
				cible=(Heros)
		}
	}

	private void setDisponible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDebutTour() throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetFinTour() throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}
}