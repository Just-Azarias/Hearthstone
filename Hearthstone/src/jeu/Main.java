package jeu;

import plateau.*;
import joueur.*;
import carte.*;
import java.util.Scanner;
import capacite.*;

public class Main {
	public static IJoueur joueur1;
	public static IJoueur joueur2;
	
	
	private static void afficherPlateau() {
		System.out.println("\n===========================================");

		System.out.println("\n===========================================");
		System.out.println("\n-------------------------------------------");
		System.out.println("\n===========================================");
		
		System.out.println("\n===========================================");
	}
	
	public static void main(String[] args) throws HearthstoneException {
		

		
		//On instencie les héros ici//
		Heros rexxar = new Heros("Rexxar", new AttaqueHeros("tir assure", "inflige 2 points de degats au heros adverse", 2 ));
		Heros jaina = new Heros("Jaina",new AttaqueCible("tir assure", "inflige 1 point de degats a la cible choisie", 1 ));

		Scanner recup = new Scanner(System.in);
		String choix;
		char caracChoix;
		String pseudo;
		
		
		////////////////////création du joueur 1/////////////////////////
		/*System.out.println("Bonjours, veuillez entrer votre pseudo (joueur 1) :");
		pseudo = recup.nextLine();*/
		pseudo="test cartes";
		
		System.out.println("Bonjours "+pseudo+" quel héros voulez-vous jouer? \nEntrez seulement la premiere lettre (seul Jaina et Rexxar sont disponible pour le moment)");
		/*do {
			choix = recup.nextLine();
			caracChoix = choix.charAt(0);
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
		pseudo="ceci est aussi un test ";
		System.out.println("Bonjours "+pseudo+" quel héros voulez-vous jouer? \nEntrez seulement la premiere lettre (seul Jaina et Rexxar sont disponible pour le moment)");
		/*do {
			choix = recup.nextLine();
			caracChoix = choix.charAt(0);
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
		System.out.println("\n\n\n\n");
		System.out.println("Le joueur 1 est : "+ joueur1);
		afficherPlateau();
		System.out.println("Le joueur 2 est : "+ joueur2);
		
	}



}
