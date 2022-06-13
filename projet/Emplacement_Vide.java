package sae201;

public class Emplacement_Vide extends Reservation{
	private float tarif;
	private int numEmplacement;
	
	public Emplacement_Vide(String etat, String date_debut, String date_fin, int num_reservation, float tarif,
			int numEmplacement) {
		super(etat, date_debut, date_fin, num_reservation);
		this.tarif = tarif;
		this.numEmplacement = numEmplacement;
	}

	public float getTarif() {
		return this.tarif;
	}

	public int getNumEmplacement() {
		return this.numEmplacement;
	}
}
