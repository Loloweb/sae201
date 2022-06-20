package projet;

import javafx.beans.property.*;

public class Contratihm extends Documentihm{
	private StringProperty valeur;
	private Clientihm signe;

	public Contratihm(String etat_Accompte, boolean reservation_payee, String valeur) {
		super(etat_Accompte, reservation_payee);
		this.valeur = new SimpleStringProperty(valeur);
	}

	public String getValeur() {
		return valeur.get();
	}
	
	public Clientihm getSignataire() {
		return this.signe;
	}
	
	public void setValeur(StringProperty val) {
		this.valeur = val;
	}
	
	public void setSigne(Clientihm signe) {
		this.signe = signe;
	}
	
	public StringProperty valeurProperty() {
		return this.valeur;
	}
	
	public void AjoutSignature(Clientihm c) {
		this.signe = c;
	}
}
