package sae201;

public class Document {
	
	private String etat_Accompte;
	private boolean reservation_payee;
	private Reservation reserver;
	
	public Document(String etat_Accompte, boolean reservation_payee) {
		this.etat_Accompte = etat_Accompte;
		this.reservation_payee = reservation_payee;
	}

	public String getEtat_Accompte() {
		return this.etat_Accompte;
	}

	public boolean isReservation_payee() {
		return this.reservation_payee;
	}
	
	public Reservation getReserver() {
		return this.reserver;
	}

	public void ajouterReservation(Reservation r) {
		if (r.getNum_reservation()!=0 && r.getDate_debut().compareTo(null)!=0) {
			this.reserver = r;
		}
	}
}
