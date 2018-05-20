package capacite

/**
*
*@author Badr Matthieu
*/
public abstract class Capacite implements ICapacite {
	private String nom;
	private String description;
	private boolean disponible = true ; // capacite héroïque 1 fois par tour
	
	public Capacite(String nom, String description) {
		this.nom = nom;
		this.description = description;
	}
	
	public void setUsed(boolean dispo) {
		this.disponible=disponible;
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
		return "La capacite " + this.nom + " : " + this.descritpion 
	}
}