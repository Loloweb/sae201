package sae201;

public class Mobil_Home extends Reservation{
	private String categorie;
	private float tarif;
	private int numEmplacement;
	
	public Mobil_Home(String etat, String date_debut, String date_fin, int num_reservation, String categorie,
			float tarif, int numEmplacement) {
		super(etat, date_debut, date_fin, num_reservation);
		this.categorie = categorie;
		this.tarif = tarif;
		this.numEmplacement = numEmplacement;
	}

	public String getCategorie() {
		return this.categorie;
	}

	public float getTarif() {
		return this.tarif;
	}

	public int getNumEmplacement() {
		return this.numEmplacement;
	}
}
