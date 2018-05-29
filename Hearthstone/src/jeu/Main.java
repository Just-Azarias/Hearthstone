package jeu;

import plateau.*;
import joueur.*;
import carte.*;

import java.util.ArrayList;
import java.util.Scanner;
import capacite.*;

public class Main {
	public static IJoueur joueur1;
	public static IJoueur joueur2;
	private static Scanner recup = new Scanner(System.in);
	private static int choix;
	private static String  choixStr;

	
	private static void sauterLigne(int i){
		int j;
		for (j=0;j<i;j++) System.out.println();
	}
	private static void passerTour() throws HearthstoneException {
		Plateau.getInstance().getJoueurCourant().finirTour();
	}
	private static void jouerCarte() throws HearthstoneException {
		System.out.println("Laquelle?(Donne un bout de son nom)");
		recup.nextLine();
		choixStr=recup.nextLine();
		System.out.println(choixStr);
		System.out.println(Plateau.getInstance().getJoueurCourant().getCarteEnMain(choixStr));
		Plateau.getInstance().getJoueurCourant().jouerCarte(Plateau.getInstance().getJoueurCourant().getCarteEnMain(choixStr));
	}
	
	private static void UtiliserCarte() throws HearthstoneException {
	}
	private static void UtiliserHeros() throws HearthstoneException {
		System.out.println("Voulez-Vous cibler un heros ou une carte?");
		Plateau.getInstance().getJoueurCourant().getHeros().getCapacite().executerAction(Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getHeros());
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
		}while (choix != 1 &&choix!= 2 &&choix!= 4 &&choix!= 4);
		if (choix==1) passerTour();
		else if (choix==2)jouerCarte();
		else if (choix==3)UtiliserCarte();
		else if (choix==4)UtiliserHeros();
		else throw new HearthstoneException("probleme choix du jeu");
	}

	


	public static void main(String[] args) throws HearthstoneException {
		

		
		//On instencie les héros ici//
		Heros rexxar = new Heros("Rexxar", new AttaqueHeros("tir assure", "inflige 2 points de degats au heros adverse", 2 ));
		Heros jaina = new Heros("Jaina",new AttaqueCible("tir assure", "inflige 1 point de degats a la cible choisie", 1 ));

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
			joueur1 = new Joueur(pseudo, jaina);
		}
		else {
			joueur1 = new Joueur(pseudo, rexxar);
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
		caracChoix='R';
		if (caracChoix=='j'||caracChoix=='J') {
			joueur2 = new Joueur(pseudo, jaina);
		}
		else {
			joueur2 = new Joueur(pseudo, rexxar);
		}
		/////////////////////////////////////////////////////////////////
		
		////////////////////ajout des joueurs dans le plateau/////////////////////////
		Plateau.getInstance().ajouterJoueur(joueur1);
		Plateau.getInstance().ajouterJoueur(joueur2);
		//////////////////////////////////////////////////////////////////////////////


		////////////////////Début de la partie////////////////////////////////////////
		Plateau.getInstance().demarrerPartie();
		while (/*Plateau.getInstance().getJoueurCourant().getHeros().getPointDeVie()>0*/i>0) {
			sauterLigne(8);
			afficherPlateau();
			jouer();
			i--;
		}
		
	}


}
