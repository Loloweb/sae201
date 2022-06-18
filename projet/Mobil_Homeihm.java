//package projet;

import javafx.beans.property.*;

public class Mobil_Homeihm extends Reservationihm{
	private StringProperty categorie;
	private FloatProperty tarif;

	
	public Mobil_Homeihm(String etat, String date_debut, String date_fin, int num_reservation, String categorie,
			float tarif, int numEmplacement) {
		super(etat, date_debut, date_fin, num_reservation,numEmplacement);
		this.categorie = new SimpleStringProperty(categorie);
		this.tarif = new SimpleFloatProperty(tarif);
	}

	public String getCategorie() {
		return categorie.get();
	}

	public float getTarif() {
		return tarif.get();
	}
	
	public void setCategorie(StringProperty categorie) {
		this.categorie = categorie;
	}

	public void setTarif(FloatProperty tarif) {
		this.tarif = tarif;
	}
	
	public StringProperty categorieProperty() {
		return this.categorie;
	}
	
	public FloatProperty tarifProperty() {
		return this.tarif;
	}
}