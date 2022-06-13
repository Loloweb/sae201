package projet;

public class Mobil_Home extends Reservation{
	private String categorie;
	private float tarif;

	
	public Mobil_Home(String etat, String date_debut, String date_fin, int num_reservation, String categorie,
			float tarif, int numEmplacement) {
		super(etat, date_debut, date_fin, num_reservation,numEmplacement);
		this.categorie = categorie;
		this.tarif = tarif;
	}

	public String getCategorie() {
		return this.categorie;
	}

	public float getTarif() {
		return this.tarif;
	}

}
