package sae201;

public class Client {
	
	static int compteur = 0;
	private int id_client;
	private String nom;
	private String prenom;
	private String ville;
	private int num_contrat;
	private int code_postal;
	private int tel;
	private int num_reservation;
	private String civilite;
	private String adresse;
	private String pays;
	private Reservation reserv;
	
	public Client(String nom, String prenom, String ville, int num_contrat, int code_postal, int tel,int num_reservation, String civilite, String adresse, String pays) {
		this.nom = nom;
		this.prenom = prenom;
		this.ville = ville;
		this.num_contrat = num_contrat;
		this.code_postal = code_postal;
		this.tel = tel;
		this.num_reservation = num_reservation;
		this.civilite = civilite;
		this.adresse = adresse;
		this.pays = pays;
		this.id_client=compteur;
		compteur++;
	}
	
	public int getId_client() {
		return this.id_client;
	}

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public String getVille() {
		return this.ville;
	}

	public int getNum_contrat() {
		return this.num_contrat;
	}

	public int getCode_postal() {
		return this.code_postal;
	}

	public int getTel() {
		return this.tel;
	}

	public int getNum_reservation() {
		return this.num_reservation;
	}

	public String getCivilite() {
		return this.civilite;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public String getPays() {
		return this.pays;
	}
	
	public Reservation getReservation() {
		return this.reserv;
	}
	
	public void ajouterReservation(Reservation r) {
		if (r.getNum_reservation()!=0 && r.getDate_debut().compareTo(null)!=0) {
			this.reserv = r;
		}
	}
	
	public void modifierReservation(Reservation r) {
		if (r!=this.reserv) {
			this.reserv = r;
		}
	}
}
