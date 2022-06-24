package projet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FenDate extends Stage{
	
	//Variables
	
	private GridPane 		racine 			= new GridPane();
	private static DatePicker		dpDateDebut		= new DatePicker();
	private static DatePicker		dpDateFin		= new DatePicker();
	private Button 			bnOK			= new Button("OK");
	
	//Constructeur

	public FenDate() {
		this.sizeToScene();
		this.setScene(new Scene (creerContenu()));
		this.setTitle("Sélectionner la date...");
		this.setMinWidth(220);
		this.setMinHeight(100);
		this.setResizable(false);
	}
	
	//Création du Contenu du SceneGraph
	
	private Parent creerContenu() {
		dpDateDebut.setValue(LocalDate.now());
		dpDateDebut.setShowWeekNumbers(true);
		dpDateFin.setValue(dpDateDebut.getValue().plusDays(7));
		dpDateFin.setShowWeekNumbers(true);
		
		dpDateDebut.valueProperty().addListener((ov, oldValue, newValue) -> {
	           dpDateFin.setValue(newValue.plusDays(8));
	    });
		
		racine.addRow(1, dpDateDebut);
		racine.addRow(2, dpDateFin);
		racine.add(bnOK, 3, 3);
		
		bnOK.setOnAction(e -> {
			System.out.println(getDateDebut());
				comparerDate();
				this.close();
		});
		
		return racine;
	}
	
	//Méthode de Comparaison des dates permettant de transférer les Clients dans une table Temporaire
	
	public void comparerDate() {
		for (Clientihm c : FenListeClients.getTableClients().getItems()) {
			for (Reservationihm r : c.getReservation()) {
				if (r.getDateDebut().isAfter(FenDate.getDateDebutld()) || r.getDateFin().isBefore(FenDate.getDateFinld())) {
					FenListeClients.getTableClientsTemp().getItems().add(c);
				}
			}
		} 
	}
	
	//Getters des dates en LocalDate
	
	public static LocalDate getDateDebutld() {
		return dpDateDebut.getValue();
	}
	
	public static LocalDate getDateFinld() {
		return dpDateFin.getValue();
	}
	
	//Convertisseurs des LocalDate en String
	
	public static String Convertisseur(LocalDate d) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy");
		String dateformatter = d.format(formatter);
		return dateformatter;
	}
	
	//Getters des dates en String
	
	public static String getDateDebut() {
		return Convertisseur(getDateDebutld());
	}
	
	public static String getDateFin() {
		return Convertisseur(getDateFinld());
	}
}