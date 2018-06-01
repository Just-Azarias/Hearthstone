package jeu;

/**
 * 	Une carte du jeu, elle peut etre une carte de sort ou une carte serviteur.
 *	Une carte est caracterise par les informations suivante:
 *	un nom
 *	une cout en mana
 *	son proprietaire
 *	sa capacite
 * 	@see ICarte
 * 	@author Bader Matthieu
 * 	@version 2.4
 * 	@see ICapacite
 */
public interface ICarte extends Cloneable {
        
         /**
         * Une carte peut avoir un effet au début de chaque tour où elle est en jeu
         * @param cible ce parametre peut être null si la carte n'a pas besoin d'une cible pour l'effet en question. 
         * La cible peut être égale à n'importe quoi d'autre qui arrange la carte (un héros, un serviteur, une autre carte) 
         * @throws HearthstoneException en cas de problème
         */
        void executerEffetDebutTour(Object cible) throws HearthstoneException;

        /**
         * Une carte peut avoir un effet à la fin de chaque tour où elle est en jeu
         * @param cible ce parametre peut être null si la carte n'a pas besoin d'une cible pour l'effet en question.
         * La cible peut être égale à n'importe quoi d'autre qui arrange la carte (un héros, un serviteur, une autre carte) 
         * @throws HearthstoneException en cas de problème
         */
        void executerEffetFinTour(Object cible) throws HearthstoneException;
        
        /**
         * Une carte peut avoir un effet au début de sa mise en jeu 
         * @param cible ce parametre peut être null si la carte n'a pas besoin d'une cible pour l'effet en question. 
         * La cible peut être égale à n'importe quoi d'autre qui arrange la carte (un héros, un serviteur, une autre carte)
         * @throws HearthstoneException en cas de problème
         */
        void executerEffetDebutMiseEnJeu(Object cible) throws HearthstoneException;
        
        /**
         * Une carte peut avoir un effet au moment de sa disparition du jeu 
         * @param cible ce parametre peut être null si la carte n'a pas besoin d'une cible pour l'effet en question. 
         * La cible peut être égale à n'importe quoi d'autre qui arrange la carte (un héros, un serviteur, une autre carte)   
         * @throws HearthstoneException en cas de problème
         */
        void executerEffetDisparition(Object cible) throws HearthstoneException;
        
        /**
         * Une carte peut avoir une action qui se commande à n'importe quel moment du tour lorsqu'elle est en jeu 
         * @param cible ce parametre peut être null si la carte n'a pas besoin d'une cible pour l'action en question. 
         * La cible peut être égale à n'importe quoi d'autre qui arrange la carte (un héros, un serviteur, une autre carte)
         * @throws HearthstoneException en cas de problème
         */
        void executerAction(Object cible) throws HearthstoneException;
        
        /**
         * Fonction qui teste si les conditions pour que la carte soit encore présente au tour suivant. Si la fonction
         * renvoie vrai, il faut sûrement la retirer du board...
         * @return true si la carte est foutu (un serviteur tué, un sort lancé, etc.)
         */
        boolean disparait();
        
        /**
         * Retourne le nom de la capacite
         * @return Nom de la capacite
         */
        String getNom();
        
        /**
         * Retourne le cout en mana d'une carte
         * @return le cout en mana de la carte
         */
        int getCout();   
        
        /**
         * Retourne le proprietaire de la carte
         * @return le propriétaire (IJoueur)
         */
        IJoueur getProprietaire();      
        
        /**
         * Retourne la capacite de la carte
         * @return la capacite (ICapacite)
         */
        ICapacite getCapacite();			
}
