package jeu;

/**
 *Une capacité, c'est l'abstraction générique pour décrire, le pouvoir du héros, le sort d'une carte Sort, la capacité d'un servicteur, etc.
 *Une capacite est caracterise par les informations suivante:
 *un nom
 *une description de ce en quoi elle consiste
 *une disponibilite
 * @see ICarte
 * @author Bader Matthieu
 * @version 1.8
 */
public interface ICapacite{
	/**
	 * Certaines capacité agissent quand on le demande, et éventuellement sur une cible
	 *  @throws HearthstoneException En cas de problème
	 */
	public void executerAction(Object cible) throws HearthstoneException;
	
	/**
	 * Certaines capacité agissent en début de tour
	 * @throws HearthstoneException En cas de problème
	 */
	public void executerEffetDebutTour() throws HearthstoneException;
	
	/**
	 * Certaines capacité agissent lorsque la carte disparaît du jeu (comme le râle d'agonie).
	 * @throws HearthstoneException En cas de problème
	 */
	public void executerEffetDisparition(Object cible) throws HearthstoneException;
	
	/**
	 * Certaines capacité agissent en fin de tour
	 * @throws HearthstoneException En cas de problème
	 */
	public void executerEffetFinTour() throws HearthstoneException;
	
	/**
	 * Certaines capacité agissent en début de mise en jeu. C'est souvent le cas des sorts.
	 * @throws HearthstoneException En cas de problème
	 */
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException;
	
	/**
	 * La description de la capacité ("Inflige +1 points de dégat au héros visé")
	 * @return Une chaine de caractères
	 */
	public String getDescription();
	
	/**
	 * Le nom de la capacité ("Boule de feu")
	 * @return Une chaine de caractères
	 */
	public String getNom();
	
	/**
	 * Si le pouvoir Heroique est disponible à l'utilisation
	 * @return True si disponible
	 */
	boolean isDisponible();
	
	/**
	 * Modifier le statut de la capacite Heroique
	 * @param dispo
	 * 			Nouveau statut
	 */
	void setUsed(boolean dispo);
}
