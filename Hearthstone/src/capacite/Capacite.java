package capacite;

import jeu.*;

/**Classe de la capacite
*
*@author Badr Matthieu
*/
public abstract class Capacite implements ICapacite {
	private String nom;
	private String description;
	private boolean disponible = true ; 
	
	public Capacite(String nom, String description) {
		this.nom = nom;
		this.description = description;
	}
	
	public void setUsed(boolean dispo) {
		this.disponible=dispo;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public String getDescription() {
		return this.description ;
	}
	public String getNom() {
		return this.nom ;
	}
	public String toString() {
		return "La capacite " + this.nom + " : " + this.description;
	}
}