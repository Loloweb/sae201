package starwars;

public class Weapon {
	
	private String nom;
	private int puissance;
	
	public Weapon(String n, int p) {
		this.nom=n;
		this.puissance=p;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getPuissance() {
		return this.puissance;
	}
	
	
}
