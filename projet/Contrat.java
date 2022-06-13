package sae201;

public class Contrat extends Document{
	private String valeur;
	private Client signe;

	public Contrat(String etat_Accompte, boolean reservation_payee, String valeur) {
		super(etat_Accompte, reservation_payee);
		this.valeur = valeur;
	}

	public String getValeur() {
		return this.valeur;
	}
	
	public Client getSignataire() {
		return this.signe;
	}
	
	public void AjoutSignature(Client c) {
		this.signe = c;
	}
}
