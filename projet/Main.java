package projet;

import javafx.application.Application;
import javafx.stage.Stage;
import vue.FenDetailEmploye;
import vue.FenListeEmployes;
import vue.FenNouveauEmploye;

public class Main extends Application{
	static private FenNouveauClient fNouvCli = new FenNouveauClient();
	static private FenDetailClient fDetailCli = new FenDetailClient();
	static private FenListeClients fListeCli = new FenListeClients();
	
	public void start(Stage s) {
		s = new FenListeClients();
		s.setResizable(true);
		s.show();
	}

	public static void main(String[] args) {
		Application.launch();
	}
	
	static public void ajouterClient(Clientihm c) {
		fListeCli.ajouterClient(c);
		FenListeClients.getLesClients().add(c);
	}
}
