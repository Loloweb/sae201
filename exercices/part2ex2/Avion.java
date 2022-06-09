package part2ex2;

import java.util.ArrayList;

public class Avion {
	
	private String immat;
	private ArrayList<Avion> tabAvion;
	
	public Avion(String i) {
		this.immat=i;
		this.tabAvion=new ArrayList<Avion>();
	}
	
	public String getImmat() {
		return this.immat;
	}
	
	public void ajout(Avion a) {
		this.tabAvion.add(a);
	}
	
	public void suppression(Avion a) {
		this.tabAvion.remove(a);
	}
	
	public void afficher() {
		System.out.println(getImmat());
	}

}
