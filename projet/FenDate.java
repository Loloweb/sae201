package projet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class FenDate extends Stage{
	private GridPane 		racine 			= new GridPane();
	private static DatePicker		dpDateDebut		= new DatePicker();
	private static DatePicker		dpDateFin		= new DatePicker();
	private Button 			bnOK			= new Button("OK");

	public FenDate() {
		this.sizeToScene();
		this.setScene(new Scene (creerContenu()));
		this.setTitle("Sélectionner la date...");
		this.setMinWidth(220);
		this.setMinHeight(100);
		this.setResizable(false);
	}
	
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
				this.close();
		});
		
		return racine;
	}
	
	public static LocalDate getDateDebutld() {
		return dpDateDebut.getValue();
	}
	
	public static LocalDate getDateFinld() {
		return dpDateFin.getValue();
	}
	
	public static String Convertisseur(LocalDate d) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy");
		String dateformatter = d.format(formatter);
		return dateformatter;
	}
	
	public static String getDateDebut() {
		return Convertisseur(getDateDebutld());
	}
	
	public static String getDateFin() {
		return Convertisseur(getDateFinld());
	}
}