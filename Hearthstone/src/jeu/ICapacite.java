
/**
 *Une capacit�, c'est l'abstraction g�n�rique pour d�crire, le pouvoir du h�ros, le sort d'une carte Sort, la capacit� d'un servicteur, etc.
 */
public interface ICapacite{
	/**
	 * Certaines capacit� agissent quand on le demande, et �ventuellement sur une cible
	 *  @throws HearthstoneException En cas de probl�me
	 */
	public void executerAction(Object cible) throws HearthstoneException;
	
	/**
	 * Certaines capacit� agissent en d�but de tour
	 * @throws HearthstoneException En cas de probl�me
	 */
	public void executerEffetDebutTour() throws HearthstoneException;
	
	/**
	 * Certaines capacit� agissent lorsque la carte dispara�t du jeu (comme le r�le d'agonie).
	 * @throws HearthstoneException En cas de probl�me
	 */
	public void executerEffetDisparition(Object cible) throws HearthstoneException;
	
	/**
	 * Certaines capacit� agissent en fin de tour
	 * @throws HearthstoneException En cas de probl�me
	 */
	public void executerEffetFinTour() throws HearthstoneException;
	
	/**
	 * Certaines capacit� agissent en d�but de mise en jeu. C'est souvent le cas des sorts.
	 * @throws HearthstoneException En cas de probl�me
	 */
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException;
	
	/**
	 * La description de la capacit� ("Inflige +1 points de d�gat au h�ros vis�")
	 * @return Une chaine de caract�res
	 */
	public String getDescription();
	
	/**
	 * Le nom de la capacit� ("Boule de feu")
	 * @return Une chaine de caract�res
	 */
	public String getNom();
}
