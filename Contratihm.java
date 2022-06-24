package projet;

import javafx.beans.property.*;

public class Contratihm extends Documentihm{
	
	//Variables
	
	private StringProperty valeur;
	private Clientihm signe;
	
	//Constructeur

	public Contratihm(String etat_Accompte, boolean reservation_payee, String valeur) {
		super(etat_Accompte, reservation_payee);
		this.valeur = new SimpleStringProperty(valeur);
	}
	
	//Getters java

	public String getValeur() {
		return valeur.get();
	}
	
	public Clientihm getSignataire() {
		return this.signe;
	}
	
	//Setters
	
	public void setValeur(StringProperty val) {
		this.valeur = val;
	}
	
	public void setSigne(Clientihm signe) {
		this.signe = signe;
	}
	
	//Getter Java
	
	public StringProperty valeurProperty() {
		return this.valeur;
	}
	
	//Méthode d'ajout de Signature dans l'ArrayList
	
	public void AjoutSignature(Clientihm c) {
		this.signe = c;
	}
}
