package part1;

public class Acteur {
	
	private String nom;
	private String prenom;
	
	public Acteur(String n, String p){
		this.nom=n;
		this.prenom=p;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public boolean equals(Acteur a) {
		return (this.nom.compareTo(a.nom)==0 && this.prenom.compareTo(a.prenom)==0);
	}
	
	public void affiche() {
		System.out.println(this.prenom+" "+this.nom);
	}
	
	public static void main(String[] args) {
		Acteur a = new Acteur("Depp", "Johnny");
		Acteur b = new Acteur("Turd", "Amber");
		a.affiche();
		System.out.println(a.equals(a));
		System.out.println(b.equals(new Acteur("Heard", "Amber")));
	}
}
