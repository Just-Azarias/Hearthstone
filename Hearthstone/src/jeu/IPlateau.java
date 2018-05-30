package jeu;

/**
 * Le plateau g�re toute la partie, notamment le d�but et la fin de partie. Il sait qui est le joueur
 * courant, qui est l'adversaire d'un joueur, etc. Il n'y a qu'un seul plateau en tout et pour tout. 
 */
public interface IPlateau {
        /**
         * Ajoute un joueur � la partie. 
         * @param joueur Le joueur � ajouter
         * @throws HearthstoneException si l'on essaie d'ajouter un 3e joueur par exemple, si le joueur est null, etc
         */
        void ajouterJoueur(IJoueur joueur) throws HearthstoneException;
        
        /**
         * Renvoie le joueur courant, c'est-�-dire celui qui a le tour et qui doit jouer
         * @return le joueur courant
         */
        IJoueur getJoueurCourant();
        
        /**
         * Le setter qui va avec le getter
         * @param joueur Le nouveau joueur courant
         * @throws HearthstoneException si le nouveau joueur est null, etc. 
         */
        void setJoueurCourant(IJoueur joueur) throws HearthstoneException;
        
        /**
         * Renvoie l'adversaire
         * @param joueur dont on veut l'adversaire
         * @return le joueur adverse
         * @throws HearthstoneException si le param est null ou si le param ne correspond � aucun des 2 joueurs de la partie, etc.
         */
        IJoueur getAdversaire(IJoueur joueur) throws HearthstoneException;

        /**
         * Ca d�marre la partie. Ca determine aleatoirement qui commence
         * @throws HearthstoneException si 2 joueurs ne sont pas ajout�s, etc
         */
        void demarrerPartie() throws HearthstoneException;
        
        /**
         * @return vrai si la partie a d�mar�e, faux sinon
         */
        boolean estDemarree();
        
        /**
         * Le joueur pass� en param�tre vient de d�cider de finir son tour. Du coup, le plateau
         *  gere le changement de joueur courant 
         * @param joueur le joueur qui a fini son tour et qui passe la main
         * @throws HearthstoneException pour que prendreTour et setJoueurCourant fonctionnent
         */
        void finTour(IJoueur joueur) throws HearthstoneException;
        
        /**
         * Le h�ros du joueur adverse du joueur pass� en param�tre est mort. Donc le joueur � gagn� !
         * @param joueur celui qui a gagn�
         * @throws HearthstoneException au cas ou on souhaite tricher !
         */
        void gagnePartie(IJoueur joueur) throws HearthstoneException;
}
