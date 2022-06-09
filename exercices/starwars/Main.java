package starwars;

public class Main {

	public static void main(String[] args) {
		Character j1 = new Character("JarJar", true);
		Character j2 = new Character("Jonesy", false);
		Lightsaber s1 = new Lightsaber("ObiJuan's", 1337, "Vert");
		Lightsaber s2 = new Lightsaber("Darksaber", -1, "Noir");
		Lightsaber s3 = new Lightsaber("Guardsmen", 500, "Jaune");
		Lightsaber s4 = new Lightsaber("Fourchette", 5, "Rouge");
		Blaster b1 = new Blaster("E-11", 30, 6);
		Blaster b2 = new Blaster("First shotter", 99, 1);
		Espece e1 = new Espece("Gongan");
		Espece e2 = new Espece("Human");
		
		j1.ajout(s1);
		j1.ajout(s2);
		j1.ajout(s3);
		j1.ajout(s4);
		j2.ajout(b1);
		j1.verifyType(e1);
		j2.verifyType(e2);
		j1.affiche();
		j2.affiche();
	}

}
