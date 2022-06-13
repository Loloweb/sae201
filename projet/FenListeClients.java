package projet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.Optional;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;

public class FenListeClients extends Stage {
	static private ObservableList<Client> lesClients = FXCollections.observableArrayList();
	// les composants de la fenetre
	private AnchorPane  		racine			= new AnchorPane();
	private TableView<Client> 	tableClients	= new TableView<Client>();
	private Button 				bnAjouter 		= new Button("Ajouter...");
	private Button 				bnModifier 		= new Button("Modifier...");
	private Button 				bnSupprimer 	= new Button("Supprimer");
	private Button 				bnFermer 		= new Button("Fermer");

	// constructeur : initialisation de la fenetre
	public FenListeClients(){
		this.setTitle("Gestion des clients");
		this.setResizable(true);
		this.sizeToScene();
		this.setScene(new Scene(creerContenu()));	
	}
	
	private Parent creerContenu() {		
		TableColumn<Client,Integer> colonne1 = new TableColumn<Client,Integer>("ID");
		colonne1.setCellValueFactory(new PropertyValueFactory<Client,Integer>("id_client"));	
		tableClients.getColumns().add(colonne1);
		TableColumn<Client, String> colonne2 = new TableColumn<Client,String>("Nom");
		colonne2.setCellValueFactory(new PropertyValueFactory<Client, String>("nom"));
		tableClients.getColumns().add(colonne2);
		TableColumn<Client, String> colonne3 = new TableColumn<Client,String>("Prénom");
		colonne3.setCellValueFactory(new PropertyValueFactory<Client, String>("prenom"));
		tableClients.getColumns().add(colonne3);
		TableColumn<Client,Integer> colonne4 = new TableColumn<Client,Integer>("N° réservation");
		colonne4.setCellValueFactory(new PropertyValueFactory<Client, Integer>("num_reservation"));
		tableClients.getColumns().add(colonne4);
		/* TableColumn<Reservation,Integer> colonne5 = new TableColumn<Reservation, Integer>("N° emplacement");
		colonne5.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("numEmplacement"));
		tableClients.getColumns().add(colonne5); */
				
		tableClients.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			
		// detection et traitement des evenements
		bnAjouter.setPrefWidth(100);
		
		
		bnModifier.setPrefWidth(100);
		BooleanBinding rien = Bindings.equal(tableClients.getSelectionModel().selectedIndexProperty(), -1);
		
	
		bnSupprimer.setPrefWidth(100);

		
		bnFermer.setPrefWidth(100);

		// creation du Scene graph
		AnchorPane.setTopAnchor(tableClients, 10.0);
		AnchorPane.setLeftAnchor(tableClients, 10.0);
		AnchorPane.setRightAnchor(tableClients, 120.0);
		AnchorPane.setBottomAnchor(tableClients, 10.0);
		AnchorPane.setTopAnchor(bnAjouter, 30.0);
		AnchorPane.setRightAnchor(bnAjouter, 10.0);
		AnchorPane.setTopAnchor(bnModifier, 80.0);
		AnchorPane.setRightAnchor(bnModifier, 10.0);
		AnchorPane.setTopAnchor(bnSupprimer, 130.0);
		AnchorPane.setRightAnchor(bnSupprimer, 10.0);
		AnchorPane.setBottomAnchor(bnFermer, 10.0);
		AnchorPane.setRightAnchor(bnFermer, 10.0);
		racine.getChildren().addAll(tableClients, bnAjouter, bnModifier, bnSupprimer, bnFermer);
		return racine;
	}
	
	public void init(ArrayList<Client> liste) {
		lesClients.clear();
		for (int i=0; i<liste.size() ; i++) {
			lesClients.add(liste.get(i));
		}
		tableClients.setItems(lesClients);
	}

	public static ObservableList<Client> getLesClients() {
		return lesClients;
	}
	public static void setLesClients(ObservableList<Client> lesClients) {
		FenListeClients.lesClients = lesClients;
	}
	
	public void ajouterClient(Client e) {
		lesClients.add(e);
	}
	public void modifierClient(Client e) {
		boolean trouve = false;
		int i=0;
		while (!trouve && i<lesClients.size()) {
			if (lesClients.get(i).getId_client()==e.getId_client()){
				lesClients.set(i, e);
				trouve = true;
			}
			i++;
		}
	}
	public void supprimerClient(Client e) {
		lesClients.remove(e);
//		boolean trouve = false;
//		int i=0;
//		while (!trouve && i<lesClients.size()) {
//			if (lesClients.get(i).getMatricule()==mat){
//				lesClients.remove(i);
//				trouve = true;
//			}
//			i++;
//		}
	}
}
