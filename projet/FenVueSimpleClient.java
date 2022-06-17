package projet;

import javafx.beans.binding.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class FenVueSimpleClient extends Stage {
	
	Clientihm cli = new Clientihm("LECLERC", "Cleunay", 1314, 35000, "Oui.", "ben �a a un toit", "Un.");
	
	// les composants de la fenetre
	private GridPane	racine			= new GridPane();
	private Label 		lblID	= new Label("ID :");
	private Label 		lblNom			= new Label("Nom :");
	private Label 		lblPrenom	= new Label("Prenom :");
	private Label 		lblReserv		= new Label("N� R�servation :");
	private Label 		lblEmplac			= new Label("N� Emplacement :");
	private Label 		lblTypeemplac			= new Label("Type Emplacement :");
	private Label 		lblTypeMH			= new Label("Type Mobil-Home :");
	private Label 		lblperiodreserv			= new Label("P�riode de r�servation :");
	private TextField	txtID			= new TextField();
	private TextField	txtNom			= new TextField();
	private TextField	txtPrenom	= new TextField();
	private TextField	txtReserv		= new TextField();
	private TextField	txtEmplac	= new TextField();
	private TextField	txtTypeemplac			= new TextField();
	private TextField	txtTypeMH			= new TextField();
	private TextField	txtperiodreserv			= new TextField();
	
	private MenuItem optionAjouter = new MenuItem("Ajouter...");
	private MenuItem optionModifier = new MenuItem("Modifier...");
	private MenuItem optionSupprimer = new MenuItem("Supprimer");
	
	private ContextMenu menu = new ContextMenu(optionAjouter,new SeparatorMenuItem(),optionModifier,new SeparatorMenuItem(),optionSupprimer);
	
	// constructeur : initialisation de la fenetre
	public FenVueSimpleClient(){
		this.setTitle("D�tail d'un client");
		this.setResizable(true);
		this.sizeToScene();
		this.setResizable(false);
		this.setScene(new Scene(creerContenu()));	
	}
	
	// creation du Scene graph
	private Parent creerContenu() {
		
		// A FAIRE : lier les TextFields aux propri�t�s de l'objet cliloye
		txtID.textProperty().bind(Bindings.createStringBinding(()->String.valueOf(cli.getId_client()), cli.id_clientProperty()));
		txtPrenom.textProperty().bind(cli.prenomProperty());
		txtNom.textProperty().bind(cli.nomProperty());
		txtReserv.textProperty().bind(Bindings.createStringBinding(()->String.valueOf(cli.getNum_reservation()), cli.num_reservationProperty()));
		txtEmplac.textProperty().bind(Bindings.createStringBinding(()->String.valueOf(cli.getNum_emplacement()), cli.num_emplacementProperty()));
		txtTypeemplac.textProperty().bind(cli.typemplacementProperty());
		txtTypeMH.textProperty().bind(cli.typeMHProperty());
		txtperiodreserv.textProperty().bind(cli.periode_reservProperty());

		racine.addRow(0, lblID, txtID);
		racine.addRow(1, lblPrenom, txtPrenom);
		racine.addRow(2, lblNom, txtNom);
		racine.addRow(3, lblReserv, txtReserv);
		racine.addRow(4, lblEmplac, txtEmplac);
		racine.addRow(5, lblTypeemplac, txtTypeemplac);
		racine.addRow(6, lblTypeMH, txtTypeMH);
		racine.addRow(7, lblperiodreserv, txtperiodreserv);
		racine.setHgap(10);
		racine.setVgap(10);
		racine.setPadding(new Insets(10));
		return racine;
	}
}