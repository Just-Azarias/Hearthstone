package joueur;

import java.util.ArrayList;

import capacite.*;
import carte.*;
import jeu.*;
import plateau.Plateau;

public class Joueur implements IJoueur {
	final int MAXBOARD=7;
	final int MAXMANA=10;
	public Heros heros;
	public ArrayList<ICarte> deck;
	public ArrayList<ICarte> main;
	public ArrayList<ICarte> cartePlateau;
	public int mana;
	public int stockMana;
	public String pseudo;
	
	public Joueur(String pseudo, Heros heros, ArrayList<ICarte> deck) {
		setPseudo(pseudo);
		setHeros(heros);
		this.deck=deck;
		//this.setCartesNeutre(this.deck);
		//if (heros.getNom().contains("Jaina")) this.setCartesJaina(this.deck);
		//else if (heros.getNom().contains("Rexxar")) this.setCartesRexxar(this.deck);
		//else new HearthstoneException("héros non initialiser");
	}
	

    public boolean isProvocation() {
        for (ICarte carte : this.getJeu()) {
            if (carte.getCapacite() instanceof Provocation) return true;
        }
        return false;
    }

    @Override
	public void setCartesNeutre(ArrayList<ICarte> liste) {
			liste.add(new Serviteur("Chasse-marée	murloc ", 2, this,null, 2,1));
			liste.add(new Sort("Charge",1,this,null));
			liste.add(new Sort("Attaque mentale", 2, this,null ));
			liste.add(new Serviteur("Champion de Hurlevent", 7, this,null , 6, 6));
			liste.add(new Serviteur("Chef de raid", 3, this,new EffetPermanent("Bonus du chef de raid","Effet permanent sur les autres serviteurs alliés", 1, 0),2,2));
			liste.add(new Serviteur("Garde de Baie-du-butin", 5, this,new Provocation(), 5, 4));
			liste.add(new Serviteur("La missiliere temeraire", 6, this,null, 5, 2));
			liste.add(new Serviteur("L'ogre- magi", 4, this,new Provocation(), 4, 4));
			liste.add(new Serviteur("Archimage", 6, this,new Provocation(), 4, 7));
			liste.add(new Serviteur("Gnome lepreux", 1, this,new "attaque de lebreux", 1, 1));
			liste.add(new Serviteur("Golem de moissons", 3, this,new Golemisation(this), 2, 3));
	}
	
	public void setCartesJaina(ArrayList<ICarte> liste) {
		liste.add(new Sort("Choc de flamme", 7,this,null)); //attaque massive
		liste.add(new Sort("Eclair de givre",2,this,null)); //attaque du givre
		liste.add(new Sort("Intelligence des arcanes", 2,this,null)); //pioche 2 cartes
		liste.add(new Sort("Image mirroir",1,this,new ImageMiroir()));
		liste.add(new Sort("Explosion pyrotechnique", 10, this, null)); //explosion pyrotechnique
	}
	
	public void setCartesRexxar(ArrayList<ICarte> liste) {
		liste.add(new Serviteur("Busard affame", 5,this,null, 3, 2)); //pioche une carte
		liste.add(new Sort("Marque du chasseur", 1,this,new MarqueChasseur()));
		liste.add(new Sort("Tir des arcanes", 1,this,null)); //Tir des arcanes
		liste.add(new Sort("Lachez les chiens", 3,this, new InvocationChien(this))); //pas une ICapacité le invocationChien
		liste.add(new Sort("Ordre de tuer", 3,this,null)); //ordre de tuer (inflige 3 pts de degats au pers ciblé)
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
		
	}

	@Override
	public void jouerCarte(ICarte carte) throws HearthstoneException {
		if (this.main.contains(carte)){
			if (carte.getCout()>this.getStockMana()) new HearthstoneException("Pas assez de Mana");
			this.getMain().remove(carte);
			if (carte instanceof Serviteur) {
				if (this.getJeu().size()>=MAXBOARD) new HearthstoneException("Plus de places sur le plateau");
				this.cartePlateau.add(carte);
			}
			carte.executerEffetDebutMiseEnJeu(carte);
			this.setStockMana(this.getStockMana()-carte.getCout());
		}
		else new HearthstoneException("Carte non trouvé dans la main du joueur");
	}


	@Override
	public void jouerCarte(ICarte carte, Object cible) throws HearthstoneException {
		if (this.main.contains(carte)){
			if (carte.getCout()>this.getStockMana()) new HearthstoneException("Pas assez de Mana");
			this.getMain().remove(carte);
			if (carte instanceof Serviteur) {
				if (this.getJeu().size()>=MAXBOARD) new HearthstoneException("Plus de places sur le plateau");
				this.cartePlateau.add(carte);
			}
			carte.executerEffetDebutMiseEnJeu(cible);
			this.setStockMana(this.getStockMana()-carte.getCout());
		}
		else new HearthstoneException("Carte non trouvé dans la main du joueur");
	}
	
	@Override
	public void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException {
		if ( !((Serviteur) carte).peutAttaquer()) new HearthstoneException("cette carte ne peut pas etre utiliser sur ce tour");
		if (cible instanceof Heros) {
			if (((Joueur)Plateau.getInstance().getAdversaire(this)).isProvocation()) new HearthstoneException("ne peut pas attaquer de hero si l'adversaire a une carte provocation");
			//else (Serviteur )carte
		}
	}

	@Override
	public void utiliserPouvoir(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub

	}

	@Override
	public void perdreCarte(ICarte carte) throws HearthstoneException {
		this.cartePlateau.remove(carte);
	}

	//setter
	
	private void setStockMana(int i) {
		this.stockMana=i;
	}


	private void setMana(int i) {
		this.mana=i;
	}

	//getter 
	
	@Override
	public Heros getHeros() {
		return this.heros;
	}
	
	
	
	
	
	
	
	public String toString() {
		String res;
		res=getPseudo()+" son héros est : "+getHeros();
		//res=res+"\n Ses cartes sont :"+this.deck;  // patience, a voir losque les cartes fonctionneront niquel
		return res;
	}

}
