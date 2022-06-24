package projet;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.Optional;

import javafx.beans.binding.*;

public class FenDetailClient extends Stage {
	
	// Variables
	
	private GridPane			racine			= new GridPane();
	private HBox				zoneBoutons		= new HBox();
	private Label 		lblID	= new Label("ID :");
	private Label 		lblNom			= new Label("Nom :");
	private Label 		lblPrenom	= new Label("Prenom :");
	private Label 		lblReserv		= new Label("N° Réservation :");
	private Label 		lblEmplac			= new Label("N° Emplacement :");
	private Label 		lblTypeemplac			= new Label("Type Emplacement :");
	private Label 		lblTypeMH			= new Label("Type Mobil-Home :");
	private Label 		lblperiodreserv			= new Label("Période de réservation :");
	private Label	txtID			= new Label();
	private Label	txtNom			= new Label();
	private Label	txtPrenom	= new Label();
	private Label	txtReserv		= new Label();
	private Label	txtEmplac	= new Label();
	private Label	txtTypeemplac			= new Label();
	private Label	txtTypeMH			= new Label();
	private Label	txtperiodreserv			= new Label();
	private Button 				bnOK			= new Button("OK");
	private Button 				bnSupprimer 		= new Button("Supprimer");
	
	//Constructeur 
	
	public FenDetailClient(){		
		this.setTitle("Détail employé");
		this.sizeToScene();
		this.setResizable(false);
		this.setScene(new Scene(creerContenu()));	
	}
	
	//Création du Contenu du SceneGraph
	
	private Parent creerContenu() {
		
		//Méthode permettant le grisement d'un bouton avec des conditions
		
		BooleanBinding manque = Bindings.or(
			Bindings.or(txtEmplac.textProperty().isEmpty(), txtNom.textProperty().isEmpty()),
			Bindings.or(txtPrenom.textProperty().isEmpty(), txtReserv.textProperty().isEmpty())
			);
		
		//Caractéristiques des Boutons
		
		//Bouton OK
		
		bnOK.setPrefWidth(100);
		bnOK.setOnAction(e -> {
			this.close();
		});
		
		//Bouton Supprimer

		bnSupprimer.setPrefWidth(100);
		bnSupprimer.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION,
					"Supprimer le client?",ButtonType.YES, ButtonType.NO);
			alert.setTitle("Suppression...");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.YES) {
				Mainihm.getLesClients().remove(FenListeClients.getTableClients().getSelectionModel().getSelectedIndex()); 
			}
			this.close();
		});
		
		//Ajout des Variables dans le GridPane

		zoneBoutons.getChildren().addAll(bnOK, bnSupprimer);
		zoneBoutons.setSpacing(10);
		racine.addRow(0,  lblNom, txtNom);
		racine.addRow(1,  lblPrenom, txtPrenom);
		racine.addRow(2,  lblReserv, txtReserv);
		racine.addRow(3,  lblEmplac, txtEmplac);
		racine.addRow(4,  lblTypeemplac, txtTypeemplac);
		racine.addRow(5,  lblTypeMH, txtTypeMH);
		racine.addRow(6,  lblperiodreserv, txtperiodreserv);
		racine.add(zoneBoutons, 1, 10);
		racine.setHgap(10);
		racine.setVgap(15);
		racine.setPadding(new Insets(10));
		
		return racine;
	}
	
	//Méthode d'accès aux données du Clients Sélectionné
	
	public void init() {
		txtNom.setText(FenListeClients.getTableClients().getSelectionModel().getSelectedItem().getNom());
		txtPrenom.setText(FenListeClients.getTableClients().getSelectionModel().getSelectedItem().getPrenom());
		txtReserv.setText(String.valueOf(FenListeClients.getTableClients().getSelectionModel().getSelectedItem().getNum_reservation()));
		txtEmplac.setText(String.valueOf(FenListeClients.getTableClients().getSelectionModel().getSelectedItem().getNum_emplacement()));
		txtTypeemplac.setText(FenListeClients.getTableClients().getSelectionModel().getSelectedItem().getTypemplacement());
		txtTypeMH.setText(FenListeClients.getTableClients().getSelectionModel().getSelectedItem().getTypeMH());
		txtperiodreserv.setText(String.valueOf(FenListeClients.getTableClients().getSelectionModel().getSelectedItem().getPeriode_reserv()));
	}
}
