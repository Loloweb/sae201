package projet;

import java.time.LocalDate;
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

public class FenDate extends Stage{
	private GridPane 		racine 			= new GridPane();
	private DatePicker		dpDateDebut		= new DatePicker();
	private DatePicker		dpDateFin		= new DatePicker();
	private Button 			bnOK			= new Button("OK");

	public FenDate() {
		this.sizeToScene();
		this.setScene(new Scene (creerContenu()));
		this.setTitle("Sélectionner la date...");
		this.setMinWidth(250);
		this.setMinHeight(250);
		this.setResizable(false);
	}
	private Parent creerContenu() {
		dpDateDebut.setValue(LocalDate.now());
		dpDateFin.setValue(dpDateDebut.getValue().plusDays(7));
		
		dpDateDebut.valueProperty().addListener((ov, oldValue, newValue) -> {
	           dpDateFin.setValue(newValue.plusDays(7));
	    });
		
		racine.addRow(1, dpDateDebut);
		racine.addRow(2, dpDateFin);
		racine.addRow(3,bnOK);
		
		bnOK.setOnAction(e -> {
			if (dpDateDebut.getValue().isBefore(LocalDate.now())){
				Alert alert = new Alert(AlertType.ERROR,
						"La date sélectionnée est incorrecte. Elle doit être au moins égale à la date du jour.",ButtonType.OK);
				alert.setTitle("Problème de date");
				Optional<ButtonType> result = alert.showAndWait();
			} else {
				System.exit(0);
			}
		});
		
		return racine;
	}
}
