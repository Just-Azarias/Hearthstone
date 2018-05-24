package joueur;

import java.util.ArrayList;

import capacite.*;
import carte.*;
import jeu.*;

public class Joueur implements IJoueur {
	final int MAXMANA=10;
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
//	this.deck.add(new Carte("Chasse-maree murloc", 2, this, new Capacite("Cri de guerre", "Invocation d'un serviteur +1/+1")));
	public void setCartesNeutre(ArrayList<ICarte> liste) {
		if (this.deck==null) {
			liste.add(new Serviteur("Chasse-marée	murloc ", 2, this,null, 2,1));
			liste.add(new Sort("Charge",1,this,null));
			liste.add(new Sort("Attaque mentale", 2, this,null ));
			liste.add(new Serviteur("Champion de Hurlevent", 7, this,null , 6, 6));
			liste.add(new Serviteur("Chef de raid", 3, this,new EffetPermanent("Bonus du chef de raid","Effet permanent sur les autres serviteurs alliés", 1, 0),2,2));
			liste.add(new Serviteur("Garde de Baie-du-butin", 5, this,new Provocation(), 5, 4));
			liste.add(new Serviteur("La missiliere temeraire", 6, this,null, 5, 2));
			liste.add(new Serviteur("L'ogre- magi", 4, this,new Provocation(), 4, 4));
			liste.add(new Serviteur("Archimage", 6, this,new Provocation(), 4, 7));
			liste.add(new Serviteur("Gnome lepreux", 1, this,new "attaque de lebreux, 1, 1));
			liste.add(new Serviteur("L'ogre- magi", 4, this,new Provocation(), 4, 4));
			liste.add(new Serviteur("L'ogre- magi", 4, this,new Provocation(), 4, 4));


		}
	}
	
	public void setHeros(Heros heros){
		this.heros=heros;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo=pseudo;
	}
	
	
	@Override
	public String getPseudo() {
		return this.pseudo;
	}

	@Override
	public int getMana() {
		return this.mana;
	}

	@Override
	public int getStockMana() {
		return this.stockMana;
	}

	@Override
	public ArrayList<ICarte> getMain() {
		return this.main;
	}

	@Override
	public ArrayList<ICarte> getJeu() {
		return this.cartePlateau;
	}

	@Override
	public ICarte getCarteEnJeu(String nomCarte)/* throws HearthstoneException */{
		for(ICarte n:this.cartePlateau) {
			if (n.getNom().contains(nomCarte)) return n;
		}
		//new HearthstoneException("Carte introuvable");
		return null;
	}

	@Override
	public ICarte getCarteEnMain(String nomCarteMain) {
		for(ICarte n:this.main) {
			if (n.getNom().contains(nomCarteMain)) return n;
		}
		return null;
	}

	@Override
	public void prendreTour() throws HearthstoneException {
		if (this.getMana()<MAXMANA) this.mana++;
		this.stockMana=this.mana;
		for(ICarte n:this.cartePlateau) {
			if (n instanceof Serviteur) {
				if (((Serviteur) n).getAttente()>0) ((Serviteur) n).reduireAttente();
			}
		}
	}

	@Override
	public void finirTour() throws HearthstoneException {
		//if ()
	}

	@Override
	public void piocher() throws HearthstoneException {
		// TODO Auto-generated method stub

	}

	@Override
	public void jouerCarte(ICarte carte) throws HearthstoneException {
		if (this.main.contains(carte)){
			if (carte.getCout()>this.getMana()) new HearthstoneException("Pas assez de Mana");
			this.main.remove(carte);
			this.cartePlateau.add(carte);
		}
		else new HearthstoneException("Carte non trouvé dans la main du joueur");
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
		this.cartePlateau.remove(carte);
	}

	@Override
	public Heros getHeros() {
		return this.heros;
	}
	
	public String toString() {
		String res;
		res=getPseudo()+" son héros est : "+getHeros();
		return res;
	}

}
