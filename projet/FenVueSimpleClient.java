package projet;

import javafx.beans.binding.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class FenVueSimpleClient extends Stage {
	
	Client cli = new Client("LECLERC", "Cleunay", "Rennes", 1314, 35000, 778697219, 1337, "non-binaire", "123 help", "Kekistan");
	
	// les composants de la fenetre
	private GridPane	racine			= new GridPane();
	private HBox		zoneBoutons		= new HBox();
	private Label 		lblId	= new Label("ID :");
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
	
	// constructeur : initialisation de la fenetre
	public FenVueSimpleClient(){
		this.setTitle("Détail d'un client");
		this.setResizable(true);
		this.sizeToScene();
		this.setResizable(false);
		this.setScene(new Scene(creerContenu()));	
	}
	
	// creation du Scene graph
	private Parent creerContenu() {
		
		// A FAIRE : lier les TextFields aux propriétés de l'objet cliloye
		txtPrenom.textProperty().bind(Bindings.createStringBinding(()->String.valueOf(cli.getPrenom()), cli.PrenomProperty()));
		txtNom.textProperty().bind(cli.nomProperty());
		txtVille.textProperty().bind(cli.VilleProperty());
		txtDepartement.textProperty().bind(Bindings.createStringBinding(()->String.valueOf(cli.getDept()), cli.deptProperty()));
		
		
		bnChangerNom.setPrefWidth(100);
		bnChangerNom.setOnAction(e -> {
			cli.setNom("BIRAUD");
		});
		
		bnChangerVille.setPrefWidth(100);
		bnChangerVille.setOnAction(e -> {
			cli.setVille("INGENIEUR");
		});

		racine.addRow(0, lblPrenom, txtPrenom);
		racine.addRow(1, lblNom, txtNom);
		racine.addRow(2, lblVille, txtVille);
		racine.addRow(3, lblDepartement, txtDepartement);
		zoneBoutons.getChildren().addAll(bnChangerNom, bnChangerVille);
		racine.add(zoneBoutons, 1, 4);
		racine.setHgap(10);
		racine.setVgap(10);
		racine.setPadding(new Insets(10));
		return racine;
	}
}