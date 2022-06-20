package projet;

import java.util.ArrayList;
import javafx.beans.property.*;

public class Reservationihm {
	private StringProperty etat;
	private StringProperty date_debut;
	private StringProperty date_fin;
	private IntegerProperty num_reservation;
	private IntegerProperty numEmplacement;
	private ArrayList<Documentihm> MesDocuments;
	
	public Reservationihm(String etat, String date_debut, String date_fin, int num_reservation,int numEmplacement) {
		this.etat = new SimpleStringProperty(etat);
		this.date_debut = new SimpleStringProperty(date_debut);
		this.date_fin = new SimpleStringProperty(date_fin);
		this.num_reservation = new SimpleIntegerProperty(num_reservation);
		this.numEmplacement = new SimpleIntegerProperty(numEmplacement);
	}

	public String getEtat() {
		return etat.get();
	}

	public String getDate_debut() {
		return date_debut.get();
	}

	public String getDate_fin() {
		return date_fin.get();
	}

	public int getNum_reservation() {
		return num_reservation.get();
	}
	
	public int getNumEmplacement() {
		return numEmplacement.get();
	}
	
	public void setEtat(StringProperty etat) {
		this.etat = etat;
	}
	
	public void setDate_debut(StringProperty date_deb) {
		this.date_debut = date_deb;
	}
	
	public void setDate_fin(StringProperty date_fin) {
		this.date_fin = date_fin;
	}
	
	public void setNum_reserv(IntegerProperty num_reserv) {
		this.num_reservation = num_reserv;
	}
	
	public void setNum_Emplac(IntegerProperty num_emp) {
		this.numEmplacement = num_emp;
	}
	
	public StringProperty etatProperty() {
		return this.etat;
	}
	
	public StringProperty date_debProperty() {
		return this.date_debut;
	}
	
	public StringProperty date_finProperty() {
		return this.date_fin;
	}
	
	public IntegerProperty num_reservProperty() {
		return this.num_reservation;
	}
	
	public IntegerProperty num_emplacProperty() {
		return this.numEmplacement;
	}
	
	public void enregistreDocument(Documentihm d) {
		if (d.getEtat_Accompte().compareTo(null)!=0) {
			MesDocuments.add(d);
		}
	}
	
	public void archiverDocument(Documentihm d) {
		if(this.MesDocuments.size()>1) {
			this.MesDocuments.remove(d);
		}
	}
}