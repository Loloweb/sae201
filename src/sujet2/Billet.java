package sujet2;

import java.util.Date;

public class Billet {
	
	private Date datesp;
	private String heure_debut;
	private Client achete;
	
	public Billet(Date d, String hd) {
		this.datesp=d;
		this.heure_debut=hd;
	}

	public Date getDate() {
		return this.datesp;
	}
	
	public String getHD() {
		return this.heure_debut;
	}
	
	public void affiche() {
		System.out.println("Le "+getDate()+ " à "+getHD());
	}
	
	public void clientPossede(Client c) {
		if (c.getID()==0) {
			System.out.println("L'ID n'existe pas.");
		} else if (c.getNom()==null) {
			System.out.println("Le nom n'existe pas.");
		} else {
			this.achete=c;
		}
	}

}
