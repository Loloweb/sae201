package projet;

import javafx.beans.property.*;

public class Factureihm extends Documentihm {
	
	private FloatProperty tarif_accompte;
	private FloatProperty tarif_reservation;
	private StringProperty libelle_prestation;
	private Clientihm regle;
	
	public Factureihm(String etat_Accompte, boolean reservation_payee, float tarif_accompte, float tarif_reservation,
			String libelle_prestation) {
		super(etat_Accompte, reservation_payee);
		this.tarif_accompte = new SimpleFloatProperty(tarif_accompte);
		this.tarif_reservation = new SimpleFloatProperty(tarif_reservation);
		this.libelle_prestation = new SimpleStringProperty(libelle_prestation);
	}

	public float getTarif_accompte() {
		return tarif_accompte.get();
	}

	public float getTarif_reservation() {
		return tarif_reservation.get();
	}

	public String getLibelle_prestation() {
		return libelle_prestation.get();
	}
	
	public void setTarif_accompte(FloatProperty tarif) {
		this.tarif_accompte = tarif;
	}
	
	public void setTarif_reservation(FloatProperty tarif) {
		this.tarif_reservation = tarif;
	}
	
	public void setLibelle_prestation(StringProperty libelle) {
		this.libelle_prestation = libelle;
	}
	
	public FloatProperty tarif_accompteProperty() {
		return this.tarif_accompte;
	}
	
	public FloatProperty tarif_reservation() {
		return this.tarif_reservation;
	}
	
	public StringProperty libelle_prestationProperty() {
		return this.libelle_prestation;
	}
	
	public Clientihm getRegle() {
		return this.regle;
	}
	
	public void ClientRegle(Clientihm c) {
		this.regle = c;
	}
}