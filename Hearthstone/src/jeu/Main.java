package jeu;

import plateau.*;
import joueur.*;
import carte.*;
import capacite.*;

public class Main {

	public static void main(String[] args) throws HearthstoneException {
		Heros rexxar = new Heros("Rexxar");
		Joueur joueur1 = new Joueur("joueur 1", rexxar);
		
		Heros jaina = new Heros("Jaina");
		Joueur joueur2 = new Joueur("joueur 2", jaina);
		Plateau plateau = new Plateau(joueur1, joueur2);
		System.out.println("Le joueur 1 est : "+ joueur1);
		System.out.println("Le joueur 2 est : "+ joueur2);
		
	}

}
