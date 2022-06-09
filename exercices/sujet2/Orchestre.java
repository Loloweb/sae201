package sujet2;

public class Orchestre {
	
	private String nom;
	private Billet concerne;
	
	public Orchestre(String n) {
		this.nom=n;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void affiche() {
		System.out.println(getNom());
	}
	
	public void affecterBillet(Billet b) {
		if (b.getDate()==null) {
			System.out.println("La date n'existe pas.");
		} else if (b.getHD()==null) {
			System.out.println("L'heure de début n'existe pas.");
		} else {
			this.concerne = b;
		}
	}

}
