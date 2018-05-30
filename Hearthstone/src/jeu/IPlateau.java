package jeu;

/**
 * >La classe plateau gere tout ce qui se passe au niveau des deux joueur, le courant et l'adversaire
 * Elle est composee de :
 * l'unique plateau, objet Plateau unique sur lequel tout le jeu se deroule
 * Joueur courant le joueur qui doit jouer
 * demaree booleen pour savoir si la partie est demaree ou non
 * @see IJoueur
 * @author Bader Matthieu
 * @version 2.3
 */
public interface IPlateau {
        /**
         * Ajoute un joueur à la partie. 
         * @param joueur Le joueur à ajouter
         * @throws HearthstoneException si l'on essaie d'ajouter un 3e joueur par exemple, si le joueur est null, etc
         */
        void ajouterJoueur(IJoueur joueur) throws HearthstoneException;
        
        /**
         * Renvoie le joueur courant, c'est-à-dire celui qui a le tour et qui doit jouer
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
         * @throws HearthstoneException si le param est null ou si le param ne correspond à aucun des 2 joueurs de la partie, etc.
         */
        IJoueur getAdversaire(IJoueur joueur) throws HearthstoneException;

        /**
         * Ca démarre la partie. Ca determine aleatoirement qui commence
         * @throws HearthstoneException si 2 joueurs ne sont pas ajoutés, etc
         */
        void demarrerPartie() throws HearthstoneException;
        
        /**
         * @return vrai si la partie a démarée, faux sinon
         */
        boolean estDemarree();
        
        /**
         * Le joueur passé en paramètre vient de décider de finir son tour. Du coup, le plateau
         *  gere le changement de joueur courant 
         * @param joueur le joueur qui a fini son tour et qui passe la main
         * @throws HearthstoneException pour que prendreTour et setJoueurCourant fonctionnent
         */
        void finTour(IJoueur joueur) throws HearthstoneException;
        
        /**
         * Le héros du joueur adverse du joueur passé en paramètre est mort. Donc le joueur à gagné !
         * @param joueur celui qui a gagné
         * @throws HearthstoneException au cas ou on souhaite tricher !
         */
        void gagnePartie(IJoueur joueur) throws HearthstoneException;
}
