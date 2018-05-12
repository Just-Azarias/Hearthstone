package jeu;

public class Heros {
	private String nom;
	private int pointDeVie=15;
	private boolean pouvoir=true;
	
	public Heros(String nom) {
		setNom(nom);
	}
	
	//setter
	
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
	
	public String toString() {
		return getNom()+" point de vie : "+ getPointDeVie();
	}
}
