
/**
 *Une capacité, c'est l'abstraction générique pour décrire, le pouvoir du héros, le sort d'une carte Sort, la capacité d'un servicteur, etc.
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
}
