package joueur;

import java.util.ArrayList;
import java.util.Collections;

import capacite.*;
import carte.*;
import jeu.*;
import plateau.Plateau;

public class Joueur implements IJoueur {
	public final static int MAX_BOARD=7;
	public final static int MAX_MANA=10;
	public final static int TAILLE_DECK = 15;
	public Heros heros;
	private ArrayList<ICarte> deck;
	public ArrayList<ICarte> main;
	public ArrayList<ICarte> cartePlateau;
	public int mana;
	public int stockMana;
	public String pseudo;
	
	public Joueur(String pseudo, Heros heros) throws HearthstoneException {

		this.deck=new ArrayList<ICarte>();
		this.cartePlateau=new ArrayList<ICarte>();
		this.main=new ArrayList<ICarte>();
		setPseudo(pseudo);
		setHeros(heros);
		this.setCartesNeutre();
		if (heros.getNom().contains("Jaina")) this.setCartesJaina(this.deck);
		else if (heros.getNom().contains("Rexxar")) this.setCartesRexxar(this.deck);
		else new HearthstoneException("héros non initialiser");
		melanger();
	}
	
	public void melanger() {
		Collections.shuffle(this.deck);
	}
	
    public boolean isProvocation() {
        for (ICarte carte : this.getJeu()) {
            if (carte.getCapacite() instanceof Provocation) return true;
        }
        return false;
    }

    @Override
    public void setCartesNeutre() throws HearthstoneException {
			this.deck.add(new Serviteur("Chasse-marée murloc ", 2, this,new InvocationServiteur("Cri de guerre","Invoque un serviteur +1/+1" ,new  Serviteur("Eclaireur murloc", 0, this, 1, 1) ,1), 2,1));
			this.deck.add(new Sort("Charge",1,this,new Charge()));
			this.deck.add(new Sort("Attaque mentale", 2, this,new AttaqueHeros("Attaque mentale", "Inflige  points de degats au heros ennemis", 5) ));
			this.deck.add(new Serviteur("Champion de Hurlevent", 7, this,new EffetPermanent("Bonus du hurlevent", "Donne un bonus aux autres serviteurs allies de +1/+1", 1, 1) , 6, 6));
			this.deck.add(new Serviteur("Chef de raid", 3, this,new EffetPermanent("Bonus du chef de raid","Effet permanent sur les autres serviteurs alliés de +1/0", 1, 0),2,2));
			this.deck.add(new Serviteur("Garde de Baie-du-butin", 5, this,new Provocation(), 5, 4));
			this.deck.add(new Serviteur("La missiliere temeraire", 6, this,new Charge(), 5, 2));
			this.deck.add(new Serviteur("L'ogre- magi", 4, this,new Provocation(), 4, 4));
			this.deck.add(new Serviteur("Archimage", 6, this,new Provocation(), 4, 7));
			this.deck.add(new Serviteur("Gnome lepreux", 1, this,new AttaqueCible("Attaque de lepreux","Inflige 2 de degat", 2), 1, 1));
			this.deck.add(new Serviteur("Golem de moissons", 3, this,new Golemisation(this), 2, 3));
	}
	
	public void setCartesJaina(ArrayList<ICarte> deck2) throws HearthstoneException {
		deck2.add(new Sort("Choc de flamme", 7,this,new AttaqueTotale("Attaque massive","Inflige 4 points de degats a tous les serviteurs adverses", 4)));
		deck2.add(new Sort("Eclair de givre",2,this,new AttaqueCible("Attaque du givre","Inflige 3 points de degats  au personnage cible",3)));
		deck2.add(new Sort("Intelligence des arcanes", 2,this,new Pioche(2))); 
		deck2.add(new Sort("Image mirroir",1,this,new ImageMiroir(this)));
		deck2.add(new Sort("Explosion pyrotechnique", 10, this, new AttaqueCible("Explosion pyrotechnique","Inflige 10 points de degats  au personnage cible",10))); 
	}
	
	public void setCartesRexxar(ArrayList<ICarte> deck2) throws HearthstoneException {
		
		deck2.add(new Serviteur("Busard affame", 5,this,new Pioche(1), 3, 2)); 
		deck2.add(new Sort("Marque du chasseur", 1,this,new MarqueChasseur()));
		deck2.add(new Sort("Tir des arcanes", 1,this,new AttaqueCible("Tir des aecanes","Inflige 2 points de degats  au personnage cible",2)));
		deck2.add(new Sort("Lachez les chiens", 3,this, new InvocationChien(this)));
		deck2.add(new Sort("Ordre de tuer", 3,this,new AttaqueCible("Ordre de tuer","Inflige 3 points de degats  au personnage cible",3)));
	}
	
	public boolean equals(Object joueur) {
		if (joueur==null) return false;
		if (this!=joueur) return false;
		if (!(joueur instanceof IJoueur)) return false;
		if (((Joueur)joueur).getHeros()!=this.getHeros()) return false;
		if (((Joueur)joueur).getPseudo()!=this.getPseudo()) return false;
		if (((Joueur)joueur).getJeu()!=this.getJeu()) return false;
		return true;
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
		if (this.getMana()<MAX_MANA) this.mana++;
		this.stockMana=this.mana;
		piocher();
		if (this.cartePlateau!=null) {
			for(ICarte n:this.cartePlateau) {
				if (n instanceof Serviteur) {
					if (((Serviteur) n).getPeuJouer()>0) ((Serviteur) n).reduirePeuJouer();
				}
			}
		}
	}

	@Override
	public void finirTour() throws HearthstoneException{
		if (Plateau.getInstance().getJoueurCourant().equals(this)) {
			for (ICarte carte : this.getJeu()) carte.executerEffetFinTour(Plateau.getInstance().getAdversaire(this));
			Plateau.getInstance().finTour(this);
			Plateau.getInstance().getAdversaire(this).prendreTour();
		}
	}

	@Override
	public void piocher() throws HearthstoneException {
		this.main.add(this.deck.get(0));
		this.deck.remove(0);
	}

	@Override
	public void jouerCarte(ICarte carte) throws HearthstoneException {
		if (this.main.contains(carte)){
			if (carte.getCout()>this.getStockMana()) new HearthstoneException("Pas assez de Mana");
			this.getMain().remove(carte);
			if (carte instanceof Serviteur) {
				if (this.getJeu().size()>=MAX_BOARD) throw new HearthstoneException("Plus de places sur le plateau");
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
			if (carte.getCout()>this.getStockMana()) throw new HearthstoneException("Pas assez de Mana");
			this.getMain().remove(carte);
			if (carte instanceof Serviteur) {
				if (this.getJeu().size()>=MAX_BOARD) throw new HearthstoneException("Plus de places sur le plateau");
				this.cartePlateau.add(carte);
			}
			carte.executerEffetDebutMiseEnJeu(cible);
			this.setStockMana(this.getStockMana()-carte.getCout());
		}
		else throw new HearthstoneException("Carte non trouvé dans la main du joueur");
	}
	
	@Override
	public void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException {
		if ( !((Serviteur) carte).peutAttaquer()) throw new HearthstoneException("cette carte ne peut pas etre utiliser sur ce tour");
		if (cible instanceof Heros) {
			if (((Joueur)Plateau.getInstance().getAdversaire(this)).isProvocation()) throw new HearthstoneException("ne peut pas attaquer de hero si l'adversaire a une carte provocation");
			else {
				((Heros)cible).setPointDeVie(((Heros) cible).getPointDeVie()-((Serviteur )carte).getPointAttaque());
				((Serviteur)carte).reduirePeuJouer();
			}
		}
		if (cible instanceof Serviteur) {
			if (((Joueur)Plateau.getInstance().getAdversaire(this)).isProvocation()) {
				if (!(((Serviteur)cible).getCapacite() instanceof Provocation)) throw new HearthstoneException("ne peut attaquer ccette carte car une carte provocation est mise en jeu");
				else {
					((Serviteur)cible).setPointDeVie(((Serviteur) cible).getPointDeVie()-((Serviteur )carte).getPointAttaque());
					((Serviteur)carte).setPointDeVie(((Serviteur) carte).getPointDeVie()-((Serviteur )cible).getPointAttaque());
					((Serviteur)carte).reduirePeuJouer();
				}
			}
		}
	}

	@Override
	public void utiliserPouvoir(Object cible) throws HearthstoneException {
		if (this.heros.getPouvoir()) {
			heros.getCapacite().executerAction(cible);
			heros.setPouvoir(false);
		}
		else
			throw new HearthstoneException("le heros ne peut pas utiliser son pouvoir 2 fois");
	}

	@Override
	public void perdreCarte(ICarte carte) throws HearthstoneException {
		this.cartePlateau.remove(carte);
		carte.executerEffetDisparition(Plateau.getInstance().getAdversaire(this));
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
		res=res+"\nStockMana : "+this.getStockMana()+"\nPouvoir du heros : "+this.getHeros().getCapacite();
		return res;
	}

}
