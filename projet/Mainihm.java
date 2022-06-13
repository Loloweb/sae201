package projet;

import javafx.application.Application;
import javafx.stage.Stage;

public class Mainihm extends Application{
	
	public void start(Stage s) {
		s = new FenListeClients();
		s.setResizable(true);
		s.show();
	}

	public static void main(String[] args) {
		Application.launch();
	}
}
