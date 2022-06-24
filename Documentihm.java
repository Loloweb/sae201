package projet;

import javafx.beans.property.*;

public class Documentihm {
	
	//Variables
	
	private StringProperty etat_Accompte;
	private boolean reservation_payee;
	private Reservationihm reserver;
	
	//Constructeur
	
	public Documentihm(String etat_Accompte, boolean reservation_payee) {
		this.etat_Accompte = new SimpleStringProperty(etat_Accompte);
		this.reservation_payee = reservation_payee;
	}
	
	//Getters java

	public String getEtat_Accompte() {
		return etat_Accompte.get();
	}

	public boolean isReservation_payee() {
		return this.reservation_payee;
	}
	
	//Getters javaFX
	
	public Reservationihm getReserver() {
		return this.reserver;
	}
	
	//M�thode d'ajout d'une Reservation dans l'ArrayList

	public void ajouterReservation(Reservationihm r) {
		if (r.getNum_reservation()!=0 && r.getDateDebut().compareTo(null)!=0) {
			this.reserver = r;
		}
	}
}