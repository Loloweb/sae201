package projet;

import java.util.ArrayList;

public class AccesDonnees {
	static private ArrayList<Clientihm> LesClients = new ArrayList<Clientihm>();

	static public void connexion() { 
		LesClients.add(new Clientihm("LECLERC", "Cleunay", 1314, 35000, "Oui.", "ben ça a un toit", "Un."));
		LesClients.add(new Clientihm("MCAFEE", "John", 1337, 694206942, "Variable", "Tout ce qui est vivable", "Un."));
		LesClients.add(new Clientihm("LECLERC", "Cleunay", 1314, 35000, "Oui.", "ben ça a un toit", "Un."));
		LesClients.add(new Clientihm("LECLERC", "Cleunay", 1314, 35000, "Oui.", "ben ça a un toit", "Un."));
		LesClients.add(new Clientihm("LECLERC", "Cleunay", 1314, 35000, "Oui.", "ben ça a un toit", "Un."));
		LesClients.add(new Clientihm("LECLERC", "Cleunay", 1314, 35000, "Oui.", "ben ça a un toit", "Un."));
	}

	// méthodes de consultation : elles fournissent des listes de données
	static public ArrayList<Clientihm> getLesClients() {
		return LesClients;
	}
	
	// méthodes de mise à jour
	static public void ajouterClient(Clientihm e) {
		LesClients.add(e);
	}
	static public void supprimerClient(Clientihm e) {
		boolean trouve = false;
		int i=0;
		while (!trouve && i<LesClients.size()) {
			if (LesClients.get(i).getId_client()==e.getId_client()){
				LesClients.remove(i);
				trouve = true;
			}
			i++;
		}
	}
	static public void modifierClient(Clientihm e) {
		boolean trouve = false;
		int i=0;
		while (!trouve && i<LesClients.size()) {
			if (LesClients.get(i).getId_client()==e.getId_client()){
				LesClients.set(i, e);
				trouve = true;
			}
			i++;
		}
	}
}
