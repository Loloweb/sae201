package projet;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import presentation.Employe;
import presentation.Principale;

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
			Main.modifierClient(cli);
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
	
	public void init(ArrayList<Integer> lesSup, ArrayList<Integer> lesDep, int mat, String nom, String poste, int sup, String emb, float sal, float prime, int dep) {
		txtMatricule.setText(""+mat);
		txtNom.setText(nom);
		txtPoste.setText(poste);
		if (!emb.equals("")) {
			String dateemb[] = emb.split("/");
			int annee = Integer.parseInt(dateemb[0]);
			int mois = Integer.parseInt(dateemb[1]);
			int jour = Integer.parseInt(dateemb[2]);
			dpEmbauche.setValue(LocalDate.of(annee, mois, jour));
		}
		txtSalaire.clear();
		if (sal!=-1) txtSalaire.setText(""+sal);
		txtPrime.clear();
		if (prime!=-1) txtPrime.setText(""+prime);
		this.cbSuperieur.getItems().clear();
		for (int i=0; i<lesSup.size() ; i++) {
			this.cbSuperieur.getItems().add(""+lesSup.get(i));
		}
		this.cbSuperieur.getItems().add(0, "- aucun -");
		this.cbSuperieur.setValue(cbSuperieur.getItems().get(0));
		
		this.cbDept.getItems().clear();
		for (int i=0; i<lesDep.size() ; i++) {
			this.cbDept.getItems().add(""+lesDep.get(i));
		}
		this.cbDept.setValue(cbDept.getItems().get(0));
	}
}
