package projet;

import javafx.application.Application;
import javafx.stage.Stage;

public class Mainihm extends Application{
	static private FenDate fNvDate = new FenDate();
	
	public void start(Stage s) {
		s = new FenListeClients();
		s.setResizable(true);
		s.show();
	}

	public static void main(String[] args) {
		Application.launch();
	}
	
	static public void ouvrirDate() {
		fNvDate.show();
	}
}
