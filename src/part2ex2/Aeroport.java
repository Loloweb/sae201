package part2ex2;

import java.util.ArrayList;

public class Aeroport {
	
	private String indent;
	private String nom;
	private ArrayList<Aeroport> tabAeroport;
	
	public Aeroport(String i, String n) {
		this.indent=i;
		this.nom=n;
		this.tabAeroport = new ArrayList<Aeroport>();
	}
	
	public String getIndent() {
		return this.indent;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void ajout(Aeroport a) {
		this.tabAeroport.add(a);
	}
	
	public void suppression(Aeroport a) {
		this.tabAeroport.remove(a);
	}
	
	public void afficher() {
		System.out.println(getIndent()+" "+getNom());
	}
}
