package joueur;

import java.util.ArrayList;
import jeu.*;

public class Joueur implements IJoueur {
	public Heros heros;
	public ArrayList<ICarte> deck;
	public ArrayList<ICarte> main;
	public ArrayList<ICarte> cartePlateau;
	public int mana;
	public int stockMana;
	public String pseudo;
	
	public Joueur(String pseudo, Heros heros) {
		setPseudo(pseudo);
		setHeros(heros);
	}
	

	//setter
	
	public void setHeros(Heros heros){
		this.heros=heros;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo=pseudo;
	}
	
	
	@Override
	public String getPseudo() {
		// TODO Auto-generated method stub
		return this.pseudo;
	}

	@Override
	public int getMana() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStockMana() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ICarte> getMain() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ICarte> getJeu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICarte getCarteEnJeu(String nomCarte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICarte getCarteEnMain(String nomCarteMain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prendreTour() throws HearthstoneException {
		// TODO Auto-generated method stub

	}

	@Override
	public void finirTour() throws HearthstoneException {
		// TODO Auto-generated method stub

	}

	@Override
	public void piocher() throws HearthstoneException {
		// TODO Auto-generated method stub

	}

	@Override
	public void jouerCarte(ICarte carte) throws HearthstoneException {
		// TODO Auto-generated method stub

	}

	@Override
	public void jouerCarte(ICarte carte, Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub

	}

	@Override
	public void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub

	}

	@Override
	public void utiliserPouvoir(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub

	}

	@Override
	public void perdreCarte(ICarte carte) throws HearthstoneException {
		// TODO Auto-generated method stub

	}

	@Override
	public Heros getHeros() {
		return this.heros;
	}
	
	public String toString() {
		String res;
		res=getPseudo()+" son h�ros est : "+getHeros();
		return res;
	}

}
