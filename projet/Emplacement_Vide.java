package projet;

public class Emplacement_Vide extends Reservation{
	private float tarif;
	
	public Emplacement_Vide(String etat, String date_debut, String date_fin, int num_reservation, float tarif,
			int numEmplacement) {
		super(etat, date_debut, date_fin, num_reservation,numEmplacement);
		this.tarif = tarif;
	}

	public float getTarif() {
		return this.tarif;
	}

}
