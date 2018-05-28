package carte;

import jeu.*;

/**
*
*@author Badr Matthieu
*/
public abstract class Carte implements ICarte {
	private String nom;
	private int cout;
	private IJoueur proprietaire;
	private ICapacite capacite;
	
	public Carte(String nom, int cout, IJoueur proprietaire, ICapacite capacite) {
		this.nom = nom;
		this.cout = cout;
		this.proprietaire=proprietaire;
		this.capacite=capacite;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getCout(){
		return this.cout;
	}
	
	public ICapacite getCapacite() {
		return this.capacite;
	}
	
	public IJoueur getProprietaire() {
		return this.proprietaire;
	}
	
	public String toString(){
		return this.nom+" coute " + this.cout + "mana";
	}
	
}