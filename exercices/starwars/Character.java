package starwars;

import java.util.ArrayList;

public class Character {
	
	private String nom;
	private boolean force;
	private Espece type;
	private ArrayList<Weapon> possede;
	
	public Character(String n, boolean f) {
		this.nom=n;
		this.force=f;
		this.possede = new ArrayList<Weapon>();
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public boolean hasForce() {
		return this.force;
	}
	
	public void verifyType(Espece e) {
		if (e==null) {
			System.out.println("Espèce introuvable");
		} else {
			this.type=e;
		}
	}
	
	public void ajout(Weapon w) {
		if (this.possede.contains(w)) {
			System.out.println("Cette arme est déjà prise!");
		} else {
			this.possede.add(w);
		}
	}
	
	public void supprimer(Weapon w) {
		if (!this.possede.contains(w)) {
			System.out.println("Cette arme n'appartient déjà à personne!");
		} else {
			this.possede.remove(w);
		}
	}
	
	public void affiche() {
		System.out.println(this.getNom()+" type "+this.type.getType()+" a la force : "+this.hasForce());
		for (Weapon w : this.possede) {
			System.out.println(w.toString());
		}
	}
}
