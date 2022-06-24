package projet;

import java.util.ArrayList;

import javafx.beans.property.*;

public class Clientihm {
	
	static int compteur = 0;
	private IntegerProperty id_client;
	private StringProperty nom;
	private StringProperty prenom;
	private IntegerProperty num_reservation;
	private IntegerProperty num_emplacement;
	private StringProperty typemplacement;
	private StringProperty typeMH;
	private StringProperty periode_reserv;
	private ArrayList<Reservationihm> mesReservations;
	
	public Clientihm(String nom, String prenom, Integer num_reservation, Integer num_emplacement, String typemplacement, String typeMH, String periode_reserv) {
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.num_reservation = new SimpleIntegerProperty(num_reservation);
		this.num_emplacement = new SimpleIntegerProperty(num_emplacement);
		this.typemplacement = new SimpleStringProperty(typemplacement);
		this.typeMH = new SimpleStringProperty(typeMH);
		this.periode_reserv = new SimpleStringProperty(periode_reserv);
		this.id_client = new SimpleIntegerProperty(compteur);
		this.mesReservations = new ArrayList<Reservationihm>();
		compteur++;
	}

	public int getId_client() {
		return id_client.get();
	}

	public String getNom() {
		return nom.get();
	}

	public String getPrenom() {
		return prenom.get();
	}

	public int getNum_reservation() {
		return num_reservation.get();
	}

	public int getNum_emplacement() {
		return num_emplacement.get();
	}

	public String getTypemplacement() {
		return typemplacement.get();
	}
	
	public String getTypeMH() {
		return typeMH.get();
	}

	public String getPeriode_reserv() {
		return periode_reserv.get();
	}

	public void setId_client(IntegerProperty id_client) {
		this.id_client = id_client;
	}

	public void setNom(StringProperty nom) {
		this.nom = nom;
	}

	public void setPrenom(StringProperty prenom) {
		this.prenom = prenom;
	}

	public void setNum_reservation(IntegerProperty num_reservation) {
		this.num_reservation = num_reservation;
	}

	public void setNum_emplacement(IntegerProperty num_emplacement) {
		this.num_emplacement = num_emplacement;
	}

	public void setTypemplacement(StringProperty typemplacement) {
		this.typemplacement = typemplacement;
	}
	
	public void setTypeMH(StringProperty typeMH) {
		this.typeMH = typeMH;
	}

	public void setPeriode_reserv(StringProperty periode_reserv) {
		this.periode_reserv = periode_reserv;
	}
	
	public IntegerProperty id_clientProperty() {
		return this.id_client;
	}
	
	public StringProperty nomProperty() {
		return this.nom;
	}
	
	public StringProperty prenomProperty() {
		return this.prenom;
	}
	
	public IntegerProperty num_reservationProperty() {
		return this.num_reservation;
	}
	
	public IntegerProperty num_emplacementProperty() {
		return this.num_emplacement;
	}
	
	public StringProperty typemplacementProperty() {
		return this.typemplacement;
	}
	
	public StringProperty typeMHProperty() {
		return this.typeMH;
	}
	
	public StringProperty periode_reservProperty() {
		return this.periode_reserv;
	}
	
	public void ajoutReservation(Reservationihm r) {
		this.mesReservations.add(r);
	}
	
	public ArrayList<Reservationihm> getReservation() {
		return this.mesReservations;
	}
}