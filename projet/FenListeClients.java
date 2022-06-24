package projet;

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

public class FenListeClients extends Stage {
	
	//Variables
	
	private AnchorPane  		racine			= new AnchorPane();
	private static TableView<Clientihm> 	tableClients	= new TableView<Clientihm>();
	private static TableView<Clientihm>	tableClientsTemp	= new TableView<Clientihm>();
	private Button 				bnConsulter 		= new Button("Consulter");
	private Button 				bnSupprimer 	= new Button("Supprimer");
	private Button 				bnFermer 		= new Button("Fermer");
	private Button				bnDate			= new Button("Selectionner date");
	
	private MenuItem optionConsulter = new MenuItem("Consulter...");
	private MenuItem optionModifier = new MenuItem("Modifier...");
	private MenuItem optionSupprimer = new MenuItem("Supprimer");
	
	private ContextMenu menu = new ContextMenu(optionConsulter,new SeparatorMenuItem(),optionModifier,new SeparatorMenuItem(),optionSupprimer);

	//Constructeur
	
	public FenListeClients(){
		this.setTitle("Gestion des clients");
		this.setResizable(true);
		this.sizeToScene();
		this.setMinWidth(600);
		this.setMinHeight(600);
		this.setScene(new Scene(creerContenu()));	
	}
	
	//Création du Contenu du SceneGraph
	
	private Parent creerContenu() {
		
		//Méthode permettant le grisement d'un bouton avec des conditions
		
		BooleanBinding rien = Bindings.equal(getTableClients().getSelectionModel().selectedIndexProperty(), -1);
		
		//Création, ajout, et liaisons des différentes colonnes avec les données des CLients
		
		TableColumn<Clientihm,Integer> colonne1 = new TableColumn<Clientihm,Integer>("ID");
		colonne1.setCellValueFactory(new PropertyValueFactory<Clientihm,Integer>("id_client"));	
		getTableClients().getColumns().add(colonne1);
		TableColumn<Clientihm, String> colonne2 = new TableColumn<Clientihm,String>("Nom");
		colonne2.setCellValueFactory(new PropertyValueFactory<Clientihm, String>("nom"));
		getTableClients().getColumns().add(colonne2);
		TableColumn<Clientihm, String> colonne3 = new TableColumn<Clientihm,String>("Prénom");
		colonne3.setCellValueFactory(new PropertyValueFactory<Clientihm, String>("prenom"));
		getTableClients().getColumns().add(colonne3);
		TableColumn<Clientihm,Integer> colonne4 = new TableColumn<Clientihm,Integer>("N° réservation");
		colonne4.setCellValueFactory(new PropertyValueFactory<Clientihm, Integer>("num_reservation"));
		getTableClients().getColumns().add(colonne4);
		TableColumn<Clientihm,String> colonne5 = new TableColumn<Clientihm,String>("Date de début de Réservation");
		colonne5.setCellValueFactory(new PropertyValueFactory<Clientihm, String>("periode_reserv"));
		getTableClients().getColumns().add(colonne5);
		
		//Caractéristqiues de la Séléction
				
		getTableClients().getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		getTableClients().setContextMenu(menu);
			
		// detection et traitement des evenements
		
		//Bouton Consulter
		
		bnConsulter.setPrefWidth(100);
		bnConsulter.disableProperty().bind(Bindings.when(rien).then(true).otherwise(false));
		bnConsulter.setOnAction(e -> {
			Mainihm.ouvrirDetails();
		});
		
		//Bouton Date
		
		bnDate.setPrefWidth(100);
		bnDate.setOnAction(e -> {
			Mainihm.ouvrirDate();
		});
		
		//Bouton Supprimer
	
		bnSupprimer.setPrefWidth(100);
		bnSupprimer.disableProperty().bind(Bindings.when(rien).then(true).otherwise(false));
		bnSupprimer.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION,
					"Supprimer le client?",ButtonType.YES, ButtonType.NO);
			alert.setTitle("Suppression...");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.YES) {
				Mainihm.getLesClients().remove(tableClients.getSelectionModel().getSelectedIndex()); 
			}
		});
		
		//Bouton Fermer

		bnFermer.setPrefWidth(100);
		bnFermer.setOnAction(e -> System.exit(0));

		// creation du Scene graph
		AnchorPane.setTopAnchor(getTableClients(), 10.0);
		AnchorPane.setLeftAnchor(getTableClients(), 10.0);
		AnchorPane.setRightAnchor(getTableClients(), 120.0);
		AnchorPane.setBottomAnchor(getTableClients(), 10.0);
		AnchorPane.setTopAnchor(bnConsulter, 30.0);
		AnchorPane.setRightAnchor(bnConsulter, 10.0);
		AnchorPane.setTopAnchor(bnDate, 80.0);
		AnchorPane.setRightAnchor(bnDate, 10.0);
		AnchorPane.setTopAnchor(bnSupprimer, 130.0);
		AnchorPane.setRightAnchor(bnSupprimer, 10.0);
		AnchorPane.setBottomAnchor(bnFermer, 10.0);
		AnchorPane.setRightAnchor(bnFermer, 10.0);
		
		racine.getChildren().addAll(getTableClients(), bnConsulter, bnDate, bnSupprimer, bnFermer);
		
		return racine;
	}
	
	//Initialisation des différentes TableViews
	
	public void init() {
		getTableClients().getItems().clear();
		getTableClients().setItems(Mainihm.getLesClients());
	}
	
	public void initTemp() {
		getTableClientsTemp().getItems().clear();
		getTableClientsTemp().setItems(Mainihm.getLesClientsTemp());
	}
	
	//Getters des TableViews

	public static TableView<Clientihm> getTableClients() {
		return tableClients;
	}
	
	public static TableView<Clientihm> getTableClientsTemp() {
		return tableClientsTemp;
	}
}
