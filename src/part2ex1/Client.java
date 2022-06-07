package part2ex1;

public class Client {
	
	private int numero;
	private String nom;
	private String adresse;
	
	public Client(int n, String no, String a) {
		this.numero=n;
		this.nom=no;
		this.adresse=a;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getAdresse() {
		return this.adresse;
	}
	
	public void afficher() {
		System.out.println(getNumero()+" "+getNom()+" "+getAdresse());
	}
	

}
