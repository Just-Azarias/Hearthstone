package jeu;

import plateau.*;
import joueur.*;
import carte.*;
import capacite.*;

public class Main {

	public static void main(String[] args) throws HearthstoneException {
		Heros rexar = new Heros("Rexar");
		Joueur joueur1 = new Joueur("joueur 1", rexar);
		
		Heros jaina = new Heros("Jaina");
		Joueur joueur2 = new Joueur("joueur 2", jaina);
		Plateau plateau = new Plateau(joueur1, joueur2);
		
	}

}
