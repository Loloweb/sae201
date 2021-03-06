package projet;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class Mainihm extends Application{
	
	//Variables
	
	static private FenListeClients fenListeClients = new FenListeClients();
	static private FenDetailClient fenDetailClient = new FenDetailClient();
	static private ObservableList<Clientihm> lesClients = FXCollections.observableArrayList();
	static private ObservableList<Clientihm> lesClientsTemp = FXCollections.observableArrayList();
	static private FenDate fNvDate = new FenDate();
	
	//M?thode Start avec ajout de donn?es test dans la liste
	
	public void start(Stage s) throws Exception {
		lesClients.add(new Clientihm("LECLERC", "Cleunay", 1314, 35000, "Oui.", "ben ?a a un toit", "07-07-2022"));
		lesClients.add(new Clientihm("MCAFEE", "John", 1337, 694206942, "Variable", "Tout ce qui est vivable", "22-07-2022"));
		fenListeClients.init();
		fenListeClients.initTemp();
		fenListeClients.show();
	}
	
	//Lancement du Programme

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	//Diff?rents Liens avec les Fen?tres
	
	static public void ouvrirDate() {
		fNvDate.show();
	}
	
	static public void ouvrirDetails() {
		fenDetailClient.init();
		fenDetailClient.show();
	}
	
	//Diff?rents Getters
	
	public static ObservableList<Clientihm> getLesClients() {
		return lesClients;
	}
	
	public static ObservableList<Clientihm> getLesClientsTemp() {
		return lesClientsTemp;
	}
}
