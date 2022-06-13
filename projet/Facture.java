package sae201;

public class Facture extends Document {
	
	private float tarif_accompte;
	private float tarif_reservation;
	private String libelle_prestation;
	private Client regle;
	
	public Facture(String etat_Accompte, boolean reservation_payee, float tarif_accompte, float tarif_reservation,
			String libelle_prestation) {
		super(etat_Accompte, reservation_payee);
		this.tarif_accompte = tarif_accompte;
		this.tarif_reservation = tarif_reservation;
		this.libelle_prestation = libelle_prestation;
	}

	public float getTarif_accompte() {
		return this.tarif_accompte;
	}

	public float getTarif_reservation() {
		return this.tarif_reservation;
	}

	public String getLibelle_prestation() {
		return this.libelle_prestation;
	}
	
	public Client getRegle() {
		return this.regle;
	}
	
	public void ClientRegle(Client c) {
		this.regle = c;
	}
}
