
import heartstone.src.heartstone.IJoueur
/**
 * 
 * @author JustStrato&Aazarias
 *
 */
public abstract class Carte implements ICarte {
	private String nom;
	private int cout;
	private IJoueur proprietaire;
	private ICapacite capacite;
	
	public Carte(String nom, int cout, IJoueur proprietaire, ICapacite capacite) {
		this.setNom=nom;
		this.setCout=cout;
		this.proprietaire=proprietaire;
		this.capacite=capacite;
	}
	
	//gettersetters
	private void setNom(String nom) {
		if(this.nom!=null && this.nom!="") {
			this.nom=nom;
		}
		else
			throw new IllegalArgException("Nom vide");
	}
	public String getNom() {
		return this.nom;
	}
	private void setCout(int cout) {
		if(cout<0 || cout>10)
			throw new IllegalArgException("Nom vide");
		else
			this.cout=cout;
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
