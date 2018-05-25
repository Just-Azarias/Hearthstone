package jeu;

public class Heros {
	private String nom;
	private int pointDeVie=15;
	private boolean pouvoir=true;
	private ICapacite capacite;
	
	public Heros(String nom, ICapacite capacite) {
		setNom(nom);
		setCapacite(capacite);
	}
	
	//setter
	
	private void setCapacite(ICapacite capacite) {
		this.capacite=capacite;
	}

	public void setNom(String nom) {
		this.nom=nom;
	}

	public int getPointDeVie() {
		return pointDeVie;
	}

	public void setPointDeVie(int pointDeVie) {
		this.pointDeVie = pointDeVie;
	}

	public boolean isPouvoir() {
		return pouvoir;
	}

	public void setPouvoir(boolean pouvoir) {
		this.pouvoir = pouvoir;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public ICapacite getCapacite() {
		return this.capacite;
	}
	
	public String toString() {
		return getNom()+" point de vie : "+ getPointDeVie();
	}

}
