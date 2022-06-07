package part2ex1;

import java.util.ArrayList;

public class Commercial {
	
	private String identif;
	private String specialite;
	private ArrayList<ZoneGeographique> tabZg;
	
	public Commercial(String i, String s) {
		this.identif=i;
		this.specialite=s;
		this.tabZg = new ArrayList<ZoneGeographique>();
	}
	
	public String getIdentif() {
		return this.identif;
	}
	
	public String getSpecialite() {
		return this.specialite;
	}
	
	public void ajout(ZoneGeographique c) {
		this.tabZg.add(c);	
	}
	
	public void supprimer(ZoneGeographique c) {
		if (this.tabZg.size()>1) {
			this.tabZg.remove(c);
		} else {
			System.out.print("Impossible de supprimer "+c+" car le commercial n'aurait aucune zg!");
		}
	}
	
	public void afficher() {
		System.out.println(getIdentif()+" "+getSpecialite());
	}
}
