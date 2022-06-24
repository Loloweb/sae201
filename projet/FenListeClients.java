package projet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
	
	// les composants de la fenetre
	private AnchorPane  		racine			= new AnchorPane();
	private static TableView<Clientihm> 	tableClients	= new TableView<Clientihm>();
	private TableView<Clientihm>	tableClientsTemp	= new TableView<Clientihm>();
	private Button 				bnConsulter 		= new Button("Consulter");
	private Button 				bnSupprimer 	= new Button("Supprimer");
	private Button 				bnFermer 		= new Button("Fermer");
	private Button				bnDate			= new Button("Selectionner date");
	
	private MenuItem optionConsulter = new MenuItem("Consulter...");
	private MenuItem optionModifier = new MenuItem("Modifier...");
	private MenuItem optionSupprimer = new MenuItem("Supprimer");
	
	private ContextMenu menu = new ContextMenu(optionConsulter,new SeparatorMenuItem(),optionModifier,new SeparatorMenuItem(),optionSupprimer);

	// constructeur : initialisation de la fenetre
	public FenListeClients(){
		this.setTitle("Gestion des clients");
		this.setResizable(true);
		this.sizeToScene();
		this.setMinWidth(600);
		this.setMinHeight(600);
		this.setScene(new Scene(creerContenu()));	
	}
	
	private Parent creerContenu() {
		BooleanBinding rien = Bindings.equal(getTableClients().getSelectionModel().selectedIndexProperty(), -1);
		
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
		/* TableColumn<Reservation,Integer> colonne5 = new TableColumn<Reservation, Integer>("N° emplacement");
		colonne5.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("numEmplacement"));
		tableClients.getColumns().add(colonne5); */
				
		getTableClients().getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		getTableClients().setContextMenu(menu);
			
		// detection et traitement des evenements
		bnConsulter.setPrefWidth(100);
		bnConsulter.disableProperty().bind(Bindings.when(rien).then(true).otherwise(true));
		
		bnDate.setPrefWidth(100);
		bnDate.setOnAction(e -> {
			Mainihm.ouvrirDate();
		});
	
		bnSupprimer.setPrefWidth(100);
		bnSupprimer.disableProperty().bind(Bindings.when(rien).then(true).otherwise(false));
		bnSupprimer.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION,
					"Supprimer le client?",ButtonType.YES, ButtonType.NO);
			alert.setTitle("Suppression...");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.YES) {
				supprimerClient(getTableClients().getSelectionModel().getSelectedItem());
			}
		});

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
	
	public void init() {
		getTableClients().setItems(Mainihm.getLesClients());
	}
	
	public void supprimerClient(Clientihm e) {
//		lesClients.remove(e);
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
	public void comparerDate() {
		for (Clientihm c : this.getTableClients().getItems()) {
			for (Reservationihm r : c.getReservation()) {
				if (r.getDateDebut().isAfter(FenDate.getDateDebutld()) || r.getDateFin().isBefore(FenDate.getDateFinld())) {
					tableClientsTemp.getItems().add(c);
				}
			}
		} 
	}

	public static TableView<Clientihm> getTableClients() {
		return tableClients;
	}
}
