package sae201;

import java.util.ArrayList;

public class Reservation {
	private String etat;
	private String date_debut;
	private String date_fin;
	private int num_reservation;
	private ArrayList<Document> MesDocuments;
	
	public Reservation(String etat, String date_debut, String date_fin, int num_reservation) {
		this.etat = etat;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.num_reservation = num_reservation;
	}

	public String getEtat() {
		return this.etat;
	}

	public String getDate_debut() {
		return this.date_debut;
	}

	public String getDate_fin() {
		return this.date_fin;
	}

	public int getNum_reservation() {
		return this.num_reservation;
	}
	
	public void enregistreDocument(Document d) {
		if (d.getEtat_Accompte().compareTo(null)!=0) {
			MesDocuments.add(d);
		}
	}
	
	public void archiverDocument(Document d) {
		if(this.MesDocuments.size()>1) {
			this.MesDocuments.remove(d);
		}
	}
}
