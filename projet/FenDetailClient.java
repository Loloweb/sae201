package projet;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.beans.binding.*;

public class FenDetailClient extends Stage {
	
	// les composants du formulaire
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
	private TextField	txtID			= new TextField();
	private TextField	txtNom			= new TextField();
	private TextField	txtPrenom	= new TextField();
	private TextField	txtReserv		= new TextField();
	private TextField	txtEmplac	= new TextField();
	private TextField	txtTypeemplac			= new TextField();
	private TextField	txtTypeMH			= new TextField();
	private TextField	txtperiodreserv			= new TextField();
	private Button 				bnOK 			= new Button("OK");
	private Button 				bnAnnuler 		= new Button("Anuler");
	
	// constructeur : initialisation de la fenetre et des données
	public FenDetailClient(){		
		this.setTitle("Détail employé");
		this.sizeToScene();
		this.setResizable(false);
		this.setScene(new Scene(creerContenu()));	
	}
	
	private Parent creerContenu() {
		txtID.setDisable(true);
		
		BooleanBinding manque = Bindings.or(
			Bindings.or(txtEmplac.textProperty().isEmpty(), txtNom.textProperty().isEmpty()),
			Bindings.or(txtPrenom.textProperty().isEmpty(), txtReserv.textProperty().isEmpty())
			);
		bnOK.disableProperty().bind(Bindings.when(manque).then(true).otherwise(false));		
		bnOK.setPrefWidth(100);
		bnOK.setOnAction(e -> {
			Clientihm cli = new Clientihm(
				txtNom.getText(),
				txtPrenom.getText(),
				Integer.parseInt(txtReserv.getText()),
				Integer.parseInt(txtEmplac.getText()),
				txtTypeemplac.getText(),
				txtTypeMH.getText(),
				txtperiodreserv.getText()
				);	
			//todo : modifier ok
			this.close();
		});

		bnAnnuler.setPrefWidth(100);
		bnAnnuler.setOnAction(e -> {
			this.close();
		});

		zoneBoutons.getChildren().addAll(bnOK, bnAnnuler);
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
}
