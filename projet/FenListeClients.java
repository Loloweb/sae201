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
	Clientihm cli1 = new Clientihm("LECLERC", "Cleunay", 1314, 35000, "Oui.", "ben ça a un toit", "Un.");
	Clientihm cli2 = new Clientihm("MCAFEE", "John", 1337, 694206942, "Variable", "Tout ce qui est vivable", "Un.");
	static private ObservableList<Clientihm> lesClients = FXCollections.observableArrayList();
	// les composants de la fenetre
	private AnchorPane  		racine			= new AnchorPane();
	private TableView<Clientihm> 	tableClients	= new TableView<Clientihm>();
	private Button 				bnAjouter 		= new Button("Ajouter...");
	private Button 				bnModifier 		= new Button("Modifier...");
	private Button 				bnSupprimer 	= new Button("Supprimer");
	private Button 				bnFermer 		= new Button("Fermer");
	
	private MenuItem optionAjouter = new MenuItem("Ajouter...");
	private MenuItem optionModifier = new MenuItem("Modifier...");
	private MenuItem optionSupprimer = new MenuItem("Supprimer");
	
	private ContextMenu menu = new ContextMenu(optionAjouter,new SeparatorMenuItem(),optionModifier,new SeparatorMenuItem(),optionSupprimer);

	// constructeur : initialisation de la fenetre
	public FenListeClients(){
		this.setTitle("Gestion des clients");
		this.setResizable(true);
		this.sizeToScene();
		this.setScene(new Scene(creerContenu()));	
	}
	
	private Parent creerContenu() {		
		TableColumn<Clientihm,Integer> colonne1 = new TableColumn<Clientihm,Integer>("ID");
		colonne1.setCellValueFactory(new PropertyValueFactory<Clientihm,Integer>("id_client"));	
		tableClients.getColumns().add(colonne1);
		TableColumn<Clientihm, String> colonne2 = new TableColumn<Clientihm,String>("Nom");
		colonne2.setCellValueFactory(new PropertyValueFactory<Clientihm, String>("nom"));
		tableClients.getColumns().add(colonne2);
		TableColumn<Clientihm, String> colonne3 = new TableColumn<Clientihm,String>("Prénom");
		colonne3.setCellValueFactory(new PropertyValueFactory<Clientihm, String>("prenom"));
		tableClients.getColumns().add(colonne3);
		TableColumn<Clientihm,Integer> colonne4 = new TableColumn<Clientihm,Integer>("N° réservation");
		colonne4.setCellValueFactory(new PropertyValueFactory<Clientihm, Integer>("num_reservation"));
		tableClients.getColumns().add(colonne4);
		/* TableColumn<Reservation,Integer> colonne5 = new TableColumn<Reservation, Integer>("N° emplacement");
		colonne5.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("numEmplacement"));
		tableClients.getColumns().add(colonne5); */
				
		tableClients.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		tableClients.setContextMenu(menu);
			
		// detection et traitement des evenements
		bnAjouter.setPrefWidth(100);
		bnAjouter.setOnAction(e -> ajouterClient(cli1));
		
		bnModifier.setPrefWidth(100);
		BooleanBinding rien = Bindings.equal(tableClients.getSelectionModel().selectedIndexProperty(), -1);
		bnModifier.disableProperty().bind(Bindings.when(rien).then(true).otherwise(false));
		bnModifier.setOnAction(e -> { supprimerClient(tableClients.getSelectionModel().getSelectedItem());
									  ajouterClient(cli2);
									  });
	
		bnSupprimer.setPrefWidth(100);
		bnSupprimer.disableProperty().bind(Bindings.when(rien).then(true).otherwise(false));
		bnSupprimer.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION,
					"Supprimer le client?",ButtonType.YES, ButtonType.NO);
			alert.setTitle("Suppression...");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.YES) {
				supprimerClient(tableClients.getSelectionModel().getSelectedItem());
			}
		});

		bnFermer.setPrefWidth(100);
		bnFermer.setOnAction(e -> System.exit(0));

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
	
	public void init(ArrayList<Clientihm> liste) {
		lesClients.clear();
		for (int i=0; i<liste.size() ; i++) {
			lesClients.add(liste.get(i));
		}
		tableClients.setItems(lesClients);
	}

	public static ObservableList<Clientihm> getLesClients() {
		return lesClients;
	}
	public static void setLesClients(ObservableList<Clientihm> lesClients) {
		FenListeClients.lesClients = lesClients;
	}
	
	public void ajouterClient(Clientihm e) {
		lesClients.add(e);
	}
	
	public void modifierClient(Clientihm e) {
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
	public void supprimerClient(Clientihm e) {
		lesClients.remove(e);
//		boolean trouve = false;
//		int i=0;
//		while (!trouve && i<lesClients.size()) {
//			if (lesClients.get(i).getId_client()==id){
//				lesClients.remove(i);
//				trouve = true;
//			}
//			i++;
//		}
	}
}
