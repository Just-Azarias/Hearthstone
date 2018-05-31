package jeu;

import plateau.*;
import joueur.*;

import java.util.ArrayList;
import java.util.Scanner;
import capacite.*;

public class Main {
	public static IJoueur joueur1;
	public static IJoueur joueur2;
	private static Scanner recup = new Scanner(System.in);
	private static int choix,i;
	private static String  choixStr, choixStr2;

	private static void sauterLigne(int i){
		int j;
		for (j=0;j<i;j++) System.out.println();
	}
	private static void passerTour() throws HearthstoneException {
		Plateau.getInstance().getJoueurCourant().finirTour();
	}
	private static void jouerCarte() throws HearthstoneException {
		System.out.println("Laquelle?(Donne un bout de son nom)");
		choixStr=recup.nextLine();
		ICarte carte= Plateau.getInstance().getJoueurCourant().getCarteEnMain(choixStr);
		System.out.println(carte);
		if (carte.getCapacite() instanceof AttaqueCible) {
			do{
				System.out.println("Voulez-Vous cibler :\n1.Un heros \n2.Une carte?");
				choix=recup.nextInt();
				recup.nextLine();
			}while(choix!=1&&choix!=2);
			if (choix==2) {
				System.out.println("Quel cible? (Donne un bout de son nom)");
				choixStr2=recup.nextLine();
				ICarte cible=Plateau.getInstance().getAdversaire(carte.getProprietaire()).getCarteEnJeu(choixStr2);
				Plateau.getInstance().getJoueurCourant().jouerCarte(carte,cible);
			}
			else {
				Heros cible=Plateau.getInstance().getAdversaire(carte.getProprietaire()).getHeros();
				Plateau.getInstance().getJoueurCourant().jouerCarte(carte,cible);
				if (cible.getPointDeVie()<=0) Plateau.getInstance().gagnePartie(carte.getProprietaire());
			}
		}
		else Plateau.getInstance().getJoueurCourant().jouerCarte(carte);
		if (carte.getCapacite() instanceof AttaqueHeros) Plateau.getInstance().getJoueurCourant().jouerCarte(carte);
	}
	
	private static void UtiliserCarte() throws HearthstoneException {
		System.out.println("Laquelle? (Donne un bout de son nom)");
		choixStr=recup.nextLine();
		ICarte carte= Plateau.getInstance().getJoueurCourant().getCarteEnJeu(choixStr);
		if (carte!=null) {
			do{
				System.out.println("Voulez-Vous cibler :\n1.Un heros \n2.Une carte?");
				choix=recup.nextInt();
				recup.nextLine();
			}while(choix!=1&&choix!=2);
			if (choix==2) {
				System.out.println("Quel cible? (Donne un bout de son nom)");
				choixStr2=recup.nextLine();
				ICarte cible=Plateau.getInstance().getAdversaire(carte.getProprietaire()).getCarteEnJeu(choixStr2);
				Plateau.getInstance().getJoueurCourant().utiliserCarte(carte,cible);
			}
			else {
				Heros cible=Plateau.getInstance().getAdversaire(carte.getProprietaire()).getHeros();
				Plateau.getInstance().getJoueurCourant().utiliserCarte(carte,cible);
				if (cible.getPointDeVie()<=0) Plateau.getInstance().gagnePartie(carte.getProprietaire());
			}
		}
		else System.out.println("Cette carte n'est pas sur le plateau");
	}
	
	private static void UtiliserHeros() throws HearthstoneException {
		IJoueur adversaire = Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant());
		if (Plateau.getInstance().getJoueurCourant().getHeros().getCapacite().getNom().contains("tir assure")){
			Plateau.getInstance().getJoueurCourant().utiliserPouvoir(adversaire.getHeros());
		}
		else {
			do {
				System.out.println("Voulez-Vous cibler :\n1.Un heros \n2.Une carte?");
				choix=recup.nextInt();
				recup.nextLine();
			}while(choix!=1&&choix!=2);
			if (choix==1) {
				Plateau.getInstance().getJoueurCourant().utiliserPouvoir(adversaire.getHeros());
				if (adversaire.getHeros().getPointDeVie()<=0) Plateau.getInstance().gagnePartie(Plateau.getInstance().getJoueurCourant());
			}
			else {
				System.out.println("Laquelle? (Donne un bout de son nom)");
				choixStr=recup.nextLine();
				Plateau.getInstance().getJoueurCourant().utiliserPouvoir(adversaire.getCarteEnJeu(choixStr));
			}
		}
	}
	
	private static void test() throws HearthstoneException {
		for (i=0;i<15;i++) Plateau.getInstance().getJoueurCourant().piocher();
		Plateau.getInstance().getJoueurCourant().setStockMana(50);
		Plateau.getInstance().getJoueurCourant().setMana(50);

	}
	
	private static void afficherPlateau() throws HearthstoneException {
		ArrayList<ICarte> j1;
		ArrayList<ICarte> j2;
		sauterLigne(4);
		System.out.println("**************************************************");
		System.out.println(Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()));
		System.out.println("\n===========================================");
		j1=Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu();
		System.out.println(j1);
		System.out.println("\n===========================================");
		System.out.println("\n-------------------------------------------");
		System.out.println("\n===========================================");
		j2=Plateau.getInstance().getJoueurCourant().getJeu();
		System.out.println(j2);
		System.out.println("\n===========================================");
		System.out.println(Plateau.getInstance().getJoueurCourant());
		System.out.println("\n>>>>TOUR<<<<\n### Ta main ###\n###############\n"+ Plateau.getInstance().getJoueurCourant()
				.getMain()+"\n###############");
		System.out.println("**************************************************");
	}
	
	private static void jouer() throws HearthstoneException {
		sauterLigne(4);
		System.out.println("Que veux-tu faire? \n1. Finir le tour \n2. Jouer une carte de ta main \n3. Utiliser une carte en jeu \n4. Utiliser le pouvoir du heros \n\n-->");
		do {
			System.out.println("entrez 1,2,3 ou 4 selon votre choix");
			choix = recup.nextInt();
			recup.nextLine();
		}while (choix != 1 &&choix!= 2 &&choix!= 3 &&choix!= 4 &&choix!=5);
		if (choix==1) passerTour();
		else if (choix==2)jouerCarte();
		else if (choix==3)UtiliserCarte();
		else if (choix==4)UtiliserHeros();
		else if (choix==5)test();
		else throw new HearthstoneException("probleme choix du jeu");
	}

	
	public static void main(String[] args) throws HearthstoneException {
		

		
		//On instencie les héros ici//

		char caracChoix;
		String pseudo;
		int i = 50; //pour les tests
		
		
		////////////////////création du joueur 1/////////////////////////
		/*System.out.println("Bonjours, veuillez entrer votre pseudo (joueur 1) :");*/
		//pseudo = recup.nextLine();
		pseudo="test cartes";
		
		System.out.println("Bonjours "+pseudo+" quel héros voulez-vous jouer? \nEntrez seulement la premiere lettre (seul Jaina et Rexxar sont disponible pour le moment)");
		/*do {
			choixStr = recup.nextLine();
			caracChoix = choixStr.charAt(0);
		}while(caracChoix != 'j' && caracChoix != 'J' && caracChoix != 'r' && caracChoix != 'R');*/
		caracChoix='r';
		if (caracChoix=='j'||caracChoix=='J') {
			joueur1 = new Joueur(pseudo, new Heros("Jaina",new AttaqueCible("Boule de feu", "inflige 1 point de degats a la cible choisie", 1 )));
		}
		else {
			joueur1 = new Joueur(pseudo, new Heros("Rexxar", new AttaqueHeros("tir assure", "inflige 2 points de degats au heros adverse", 2 )));
		}
		
		//System.out.println("Le joueur 1 est : "+ joueur1);

		/////////////////////////////////////////////////////////////////
		
		////////////////////création du joueur 2/////////////////////////
		System.out.println("Bonjours, veuillez entrer votre pseudo (joueur 2) :");
		//pseudo = recup.nextLine();
		pseudo="ceci est aussi un test";
		System.out.println("Bonjours "+pseudo+" quel héros voulez-vous jouer? \nEntrez seulement la premiere lettre (seul Jaina et Rexxar sont disponible pour le moment)");
		/*do {
			choixStr = recup.nextLine();
			caracChoix = choixStr.charAt(0);
		}while(caracChoix != 'j' && caracChoix != 'J' && caracChoix != 'r' && caracChoix != 'R');
		*/
		caracChoix='j';
		if (caracChoix=='j'||caracChoix=='J') {
			joueur2 = new Joueur(pseudo, new Heros("Jaina",new AttaqueCible("Boule de feu", "inflige 1 point de degats a la cible choisie", 1)));
		}
		else {
			joueur2 = new Joueur(pseudo, new Heros("Rexxar", new AttaqueHeros("tir assure", "inflige 2 points de degats au heros adverse", 2)));
		}
		/////////////////////////////////////////////////////////////////
		
		////////////////////ajout des joueurs dans le plateau/////////////////////////
		Plateau.getInstance().ajouterJoueur(joueur1);
		Plateau.getInstance().ajouterJoueur(joueur2);
		//////////////////////////////////////////////////////////////////////////////


		////////////////////Début de la partie////////////////////////////////////////
		Plateau.getInstance().demarrerPartie();
		while (Plateau.getInstance().estDemarree()) {
			sauterLigne(8);
			afficherPlateau();
			jouer();
			i--;
		}
		
	}


}
