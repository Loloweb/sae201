package sujet2;

import java.util.ArrayList;

public class Client {
	
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private ArrayList<Adresse> habite;
	private ArrayList<Billet> possede;
	
	public Client(int i, String n, String p, String e) {
		this.id=i;
		this.nom=n;
		this.prenom=p;
		this.email=e;
		habite = new ArrayList<Adresse>();
		possede = new ArrayList<Billet>();
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void affiche() {
		System.out.println(getPrenom()+" "+getNom()+" ("+getID()+"), "+getEmail());
	}
	
	public void acheterBillet(Billet b) {
		if (b.getDate()==null) {
			System.out.println("Date non existante.");
		} else {
			this.possede.add(b);
		}
	}

}
