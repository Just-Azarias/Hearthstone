package carte;

import jeu.*;

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
	private String type;
	
	public Carte(String nom, int cout, IJoueur proprietaire, ICapacite capacite, String type) {
		this.setNom(nom);
		this.setCout(cout);
		this.setProprietaire(proprietaire);
		this.setCapacite(capacite);
		this.setType(type);
	}
	
	//setter  
	
	private void setCapacite(ICapacite capacite) {
		this.capacite=capacite;
	}

	private void setNom(String nom) {
		if(this.nom!=null && this.nom!="") {
			this.nom=nom;
		}
		else
			throw new IllegalArgumentException("Nom vide");
	}

	private void setCout(int cout) {
		if(cout<0 || cout>10)
			throw new IllegalArgumentException("cout errone");
		else
			this.cout=cout;
	}
	
	private void setProprietaire(IJoueur proprio) {
		this.proprietaire=proprio;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	//getter
	
	public String getNom() {
		return this.nom;
	}
	public int getCout() {
		return this.cout;
	}
	
	public IJoueur getProprietaire() {
		return this.proprietaire;
	}
	
	public ICapacite getCapacite() {
		return this.capacite;
	}
	
	public String getType() {
		return type;
	}
	
	public String toString() {
		return this.getNom()+" co�te "+this.getCout()+" manas";
	}


}
