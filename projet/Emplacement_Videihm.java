package projet;

import java.time.LocalDate;

import javafx.beans.property.*;

public class Emplacement_Videihm extends Reservationihm{
	private FloatProperty tarif;
	
	public Emplacement_Videihm(String etat, LocalDate date_debut, LocalDate date_fin, int num_reservation, float tarif,
			int numEmplacement) {
		super(etat, date_debut, date_fin, num_reservation,numEmplacement);
		this.tarif = new SimpleFloatProperty(tarif);
	}

	public float getTarif() {
		return tarif.get();
	}
	
	public  void setTarif(FloatProperty tarif) {
		this.tarif = tarif;
	}
	
	public FloatProperty tarifProperty() {
		return this.tarif;
	}
}