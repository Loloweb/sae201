package projet;

import java.time.LocalDate;

import javafx.beans.property.*;

public class Mobil_Homeihm extends Reservationihm{
	
	//Variables
	
	private StringProperty categorie;
	private FloatProperty tarif;
	
	//Constructeur
	
	public Mobil_Homeihm(String etat, LocalDate date_debut, LocalDate date_fin, int num_reservation, String categorie,
			float tarif, int numEmplacement) {
		super(etat, date_debut, date_fin, num_reservation,numEmplacement);
		this.categorie = new SimpleStringProperty(categorie);
		this.tarif = new SimpleFloatProperty(tarif);
	}
	
	//Getters java

	public String getCategorie() {
		return categorie.get();
	}

	public float getTarif() {
		return tarif.get();
	}
	
	//Setters
	
	public void setCategorie(StringProperty categorie) {
		this.categorie = categorie;
	}

	public void setTarif(FloatProperty tarif) {
		this.tarif = tarif;
	}
	
	//Getters javaFX
	
	public StringProperty categorieProperty() {
		return this.categorie;
	}
	
	public FloatProperty tarifProperty() {
		return this.tarif;
	}
}