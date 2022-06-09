package starwars;

public class Lightsaber extends Weapon {
	
	private String couleur;
	
	public Lightsaber(String n, int p, String c) {
		super(n, p);
		this.couleur=c;
	}
	
	public String getCouleur() {
		return this.couleur;
	}
	
	public String toString() {
		return "Nom : "+super.getNom()+" Puissance : "+super.getPuissance()+"Couleur : "+this.getCouleur()+" ";
	}
}
