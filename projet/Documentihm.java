package projet;

import javafx.beans.property.*;

public class Documentihm {
	
	private StringProperty etat_Accompte;
	private boolean reservation_payee;
	private Reservationihm reserver;
	
	public Documentihm(String etat_Accompte, boolean reservation_payee) {
		this.etat_Accompte = new SimpleStringProperty(etat_Accompte);
		this.reservation_payee = reservation_payee;
	}

	public String getEtat_Accompte() {
		return etat_Accompte.get();
	}

	public boolean isReservation_payee() {
		return this.reservation_payee;
	}
	
	public Reservationihm getReserver() {
		return this.reserver;
	}

	public void ajouterReservation(Reservationihm r) {
		if (r.getNum_reservation()!=0 && r.getDate_debut().compareTo(null)!=0) {
			this.reserver = r;
		}
	}
}