package part2ex1;

import java.util.ArrayList;

public class ZoneGeographique {
	
	private String nom;
	private ArrayList<Client> habite;
	
	public ZoneGeographique(String n) {
		this.nom=n;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void ajout(Client c) {
		this.habite.add(c);
	}
	
	public void suppression(Client c) {
		this.habite.remove(c);
	}
	
	public void affiche() {
		System.out.println(this.getNom());
	}
}
