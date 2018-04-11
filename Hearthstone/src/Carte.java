
import heartstone.src.heartstone.IJoueur
/**
 * 
 * @author JustStrato&Aazarias
 *
 */
public abstract class Carte implements ICarte{
	private String nom;
	private int cout;
	private IJoueur proprietaire;
	
	public Carte(String nom, int cout, IJoueur proprietaire) {
		this.nom=nom;
		this.cout=cout;
		this.proprietaire=proprietaire;
	}
	
	//gettersetters
	public String getNom() {
		return this.nom;
	}
	
	public int getCout() {
		return this.cout;
	}
	
	public IJoueur getProprietaire() {
		return this.getProprietaire();
	}
	
	public String toString() {
		return this.getNom()+" coûte "+this.getCout()+" manas";
	}
}
